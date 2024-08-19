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

import com.automationanywhere.botcommand.data.model.record.Record;
import com.automationanywhere.botcommand.data.model.region.Region;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

/**
 * This example shows how to display help.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "Help demo", 
description = "Demonstarte the display help	", icon = "sample.svg", name = "helpTypeDemo")
public class HelpTypeDemo {

	
	@Execute
	public void getDate(@Idx(index = "1", type = AttributeType.HELP)
	@Pkg(label = "Help type label", description = "This is help description")
	String record) {
		
	}
	
}
