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

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.RecordValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.GreaterThan;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.NumberInteger;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import static com.automationanywhere.commandsdk.model.DataType.RECORD;

/**
 * There will be a singleton instance of this class. Whenever a new trigger is
 * created it comes with a triggerId. In this sample we create multiple tasks
 * and store them in a map with these triggerId as the key. Once the condition
 * of trigger matches we call the run method of the runnable to signal the
 * trigger.
 * <p>
 * In the following example we will create a trigger which triggers are user
 * specified intervals.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand(commandType = BotCommand.CommandType.Trigger)
@CommandPkg(label = "Demo Trigger", description = "Demo Trigger", icon = "email.svg", name = "demoTrigger",
		return_type = RECORD, return_name = "TriggerData", return_description = "Available keys: triggerType")
public class TriggerDemo {

	// Map storing multiple tasks
	private static final Map<String, TimerTask> taskMap = new ConcurrentHashMap<>();
	private static final Timer TIMER = new Timer(true);

	@TriggerId
	private String triggerUid;
	@TriggerConsumer
	private Consumer consumer;

	/*
	 * Starts the trigger.
	 */
	@StartListen
	public void startTrigger(@Idx(index = "1", type = AttributeType.NUMBER)
	@Pkg(label = "Please provide the interval to trigger in seconds", default_value = "120", default_value_type = DataType.NUMBER)
	@GreaterThan("0")
	@NumberInteger
	@NotEmpty
	Double interval) {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				consumer.accept(getRecordValue());
			}
		};

		taskMap.put(this.triggerUid, timerTask);
		TIMER.schedule(timerTask, interval.longValue());
	}

	private RecordValue getRecordValue() {
		List<Schema> schemas = new LinkedList<>();
		List<Value> values = new LinkedList<>();
		schemas.add(new Schema("triggerType"));
		values.add(new StringValue("Interval Trigger"));

		RecordValue recordValue = new RecordValue();
		recordValue.set(new Record(schemas,values));
		return recordValue;
	}

	/*
	 * Cancel all the task and clear the map.
	 */
	@StopAllTriggers
	public void stopAllTriggers() {
		taskMap.forEach((k, v) -> {
			if (v.cancel()) {
				taskMap.remove(k);
			}
		});
	}

	/*
	 * Cancel the task and remove from map
	 *
	 * @param triggerUid
	 */
	@StopListen
	public void stopListen(String triggerUid) {
		if (taskMap.get(triggerUid).cancel()) {
			taskMap.remove(triggerUid);
		}
	}

	public void setTriggerUid(String triggerUid) {
		this.triggerUid = triggerUid;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

}
