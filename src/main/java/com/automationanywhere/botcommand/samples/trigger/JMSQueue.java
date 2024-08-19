/*
 * Copyright (c) 2023 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 * 
 */
package com.automationanywhere.botcommand.samples.trigger;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import javax.jms.JMSException;
import javax.jms.Session;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.RecordValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;
import com.automationanywhere.commandsdk.annotations.*;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

import static com.automationanywhere.commandsdk.model.DataType.RECORD;

/**
 * 
 * Lets create a simple ActiveMQ message listener. We will use
 * SimpleMessageListenerContainer to demonstrate the push mechanism.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand(commandType = BotCommand.CommandType.Trigger)
@CommandPkg(label = "JMS Trigger", description = "JMS Trigger", icon = "jms.svg", name = "jmsTrigger",
		return_type = RECORD, return_name = "TriggerData", return_description = "Available keys: triggerType")
public class JMSQueue implements SessionAwareMessageListener {

	// Map storing multiple MessageListenerContainer
	private static final Map<String, MessageListenerContainer> taskMap = new ConcurrentHashMap<>();

	@TriggerId
	private String triggerUid;
	@TriggerConsumer
	private Consumer consumer;
	
	//This method is called by MessageListenerContainer when a message arrives.
	// We will enable the trigger at this point 
	@Override
	public void onMessage(javax.jms.Message message, Session session) throws JMSException {
		consumer.accept(getRecordValue());

	}

	private RecordValue getRecordValue() {
		List<Schema> schemas = new LinkedList<>();
		List<Value> values = new LinkedList<>();
		schemas.add(new Schema("triggerType"));
		values.add(new StringValue("JMSQueue"));

		RecordValue recordValue = new RecordValue();
		recordValue.set(new Record(schemas,values));
		return recordValue;
	}
	/*
	 * Starts the trigger.
	 * 
	 * We will use this method to setup the trigger, i.e. setup the MessageListenerContainer and start it.
	 */
	@StartListen
	public void startTrigger(@Idx(index = "1", type = AttributeType.TEXT)
	@Pkg(label = "Please provide the broker URL")
	@NotEmpty
	String brokerURL, @Idx(index = "2", type = AttributeType.TEXT)
	@Pkg(label = "Please provide the queue name")
	@NotEmpty
	String queueName) {
		
		if (taskMap.get(triggerUid) == null) {
			synchronized (this) {
				if (taskMap.get(triggerUid) == null) {
					SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
					messageListenerContainer.setConnectionFactory(new PooledConnectionFactory(brokerURL));
					messageListenerContainer.setDestinationName(queueName);
					messageListenerContainer.setMessageListener(this);
					messageListenerContainer.start();
					taskMap.put(triggerUid, messageListenerContainer);

				}
			}
		}

	}

	/*
	 * Cancel all the task and clear the map.
	 */
	@StopAllTriggers
	public void stopAllTriggers() {
		taskMap.forEach((k, v) -> {
			v.stop();
			taskMap.remove(k);
		});
	}

	/*
	 * Cancel the task and remove from map
	 *
	 * @param triggerUid
	 */
	@StopListen
	public void stopListen(String triggerUid) {
		taskMap.get(triggerUid).stop();
		taskMap.remove(triggerUid);
	}

	public void setTriggerUid(String triggerUid) {
		this.triggerUid = triggerUid;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

}
