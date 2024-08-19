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

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.CodeType;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

/**
 * This example demonstrates how to accept code in the UI.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(
	label = "Python code demo",
	name = "codeTypeDemo",
	icon = "sample.svg",
	description = "[[OpenScript.description]]")
public class CodeTypeDemo {
	
	@Execute
	public void runCode(@Idx(index = "1", type = AttributeType.CODE)
	@Pkg(label = "Python Code")
	@NotEmpty
	@CodeType(value = "text/x-python")
	String firstName) {
		// Do something with the python code.
	}

}
