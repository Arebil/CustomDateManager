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

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This example shows how to display a textarea and accept value from it.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[TextAreaTypeDemo.label]]", 
description = "[[TextAreaTypeDemo.description]]", icon = "sample.svg", name = "tTextAreaTypeDemo", 
return_description = "Return the full name in variable", return_type = DataType.STRING, return_required = true)
public class TextAreaTypeDemo {

	@Execute
	public StringValue printName(@Idx(index = "1", type = AttributeType.TEXTAREA)
	@Pkg(label = "[[TextAreaTypeDemo.firstName.label]]")
	@NotEmpty
	String firstName,
	
	@Idx(index = "2", type = AttributeType.TEXTAREA)
	@Pkg(label = "[[TextAreaTypeDemo.lastName.label]]")
	@NotEmpty
	String lastName) {
		String fullName = firstName + " " + lastName;
		return new StringValue(fullName);
	}
	
}
