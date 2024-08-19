/*
 * Copyright (c) 2022 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 *
 */
package com.automationanywhere.botcommand.samples.commands.basic.GlobalSession;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.SessionObject;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
		//Unique name inside a package and label to display.
		name = "GlobalSessionChild", label = "Global session upper case child",
		node_label = "Global session child node label",
		description = "Global session child description", icon = "pkg.svg",
		
		//Return type information. return_type ensures only the right kind of variable is provided on the UI. 
		return_label = "Return the concatenated string to", return_type = STRING, return_required = true)
public class GlobalSessionDemoUpperCaseChild {
	private static Logger logger = LogManager.getLogger(GlobalSessionDemoUpperCaseChild.class);
	
	@Execute
	public Value<String> action(
			//Idx 1 would be displayed first, with a text box for entering the value.
			@Idx(index = "1", type = TEXT) 
			//UI labels.
			@Pkg(label = "Enter a sting in lower case to concatenate")
			//Ensure that a validation error is thrown when the value is null.
			@NotEmpty 
			String sourceString,
			@Idx(index = "2", type = AttributeType.SESSION)
			@Pkg(label = "sharedSession", description = "sharedSession",
					default_value = "DefaultSession", default_value_type = DataType.SESSION)
			//Using the sessionObject annotation here as its a consumer class
					@SessionObject
					DemoForSession session) {

		//Business logic
		String result = sourceString.toUpperCase();
		logger.info("session: {}",session);
		return new StringValue(result+session.getDemo().toUpperCase());
	}
}
