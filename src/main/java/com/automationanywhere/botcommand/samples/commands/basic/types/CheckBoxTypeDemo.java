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
 * 
 * This example demonstrates how to accept a boolean value using a checkbox.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[CheckBoxTypeDemo.label]]", 
description = "[[CheckBoxTypeDemo.description]]", icon = "sample.svg", name = "checkBoxTypeDemo", 
return_description = "Return whether the flag was set or not in a variable", return_type = DataType.STRING, return_required = true)
public class CheckBoxTypeDemo {

	@Execute
	public StringValue getMessage(
			@Idx(index = "1", type = AttributeType.CHECKBOX)
			@Pkg(label = "[[CheckBoxTypeDemo.isChecked.label]]")
			@NotEmpty
			Boolean isChecked) {
		if(isChecked)
			return new StringValue("The checkbox returned true");
		
		return new StringValue("The checkbox returned false");
	}
	
}
