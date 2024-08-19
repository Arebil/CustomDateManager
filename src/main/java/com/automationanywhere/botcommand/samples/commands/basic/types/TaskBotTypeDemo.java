/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 * 
 */
package com.automationanywhere.botcommand.samples.commands.basic.types;

import static com.automationanywhere.commandsdk.model.AttributeType.TASKBOT;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.automationanywhere.bot.service.GlobalSessionContext.ChildBot;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.model.Taskbot;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.GlobalSessionContext;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * Action to run other bots in CR as sub bot.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[TaskBotTypeDemo.label]]", 
description = "[[TaskBotTypeDemo.description]]", icon = "sample.svg", name = "taskBotTypeDemo", 
return_description = "Return the output in variable", return_type = DataType.ANY, return_required = false)
public class TaskBotTypeDemo {

    @GlobalSessionContext
    com.automationanywhere.bot.service.GlobalSessionContext globalSessionContext;

    public void setGlobalSessionContext( com.automationanywhere.bot.service.GlobalSessionContext globalSessionContext) {
        this.globalSessionContext = globalSessionContext;
    }
	
	@Execute
	public Value runbot(@Idx(index = "1", type = TASKBOT)
    @Pkg(label = "TaskBot type")
    Taskbot taskbot) {
        String taskbotUri = taskbot.getURI();
        Map<String, Value> inputValues = taskbot.getInput();
        ChildBot bot = globalSessionContext.getChildBotWithGlobalSessionContext(taskbotUri);
        
        Optional<Value> outputValue = (Optional<Value>) bot.getBot()
        .play(bot.getGlobalSessionContext(), inputValues, Collections.EMPTY_SET).get();
        
        return outputValue.isPresent() ? outputValue.get() : null;
	}
	
}
