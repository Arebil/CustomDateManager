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

import com.automationanywhere.botcommand.data.impl.SessionValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.ReturnSettingsType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.SESSION;


//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
		//Unique name inside a package and label to display.
		name = "GlobalSession", label = "Global session uppercase parent",
		node_label = "Shared session parent node label", description = "Shared session parent description", icon = "pkg.svg",
		
		//Return type information. return_type ensures only the right kind of variable is provided on the UI. 
		return_label = "Return the parent session",
		return_settings = {ReturnSettingsType.SESSION_TARGET},
		return_type = SESSION,
		default_session_value="DefaultSession",
		return_required = true)
public class GlobalSessionDemoForStringUpperCaseParent {
	private static Logger logger = LogManager.getLogger(GlobalSessionDemoForStringUpperCaseParent.class);

	//Identify the entry point for the action. Returns a Value<String> because the return type is String. 
	@Execute
	public SessionValue action(
			//Idx 1 would be displayed first, with a text box for entering the value.
			@Idx(index = "1", type = TEXT) 
			//UI labels.
			@Pkg(label = "Enter string in lower case")
			//Ensure that a validation error is thrown when the value is null.
			@NotEmpty 
			String firstString) {
		String result = firstString.toUpperCase();
		DemoForSession demoForSession= new DemoForSession(result);
		return SessionValue
				.builder()
				.withSessionObject(demoForSession)
				.build();
	}
}
