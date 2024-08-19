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

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This example shows how to display a textbox accepting number and accept
 * values from it.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[NumberTypeDemo.label]]", 
description = "[[NumberTypeDemo.description]]", icon = "sample.svg", name = "numberTypeDemo", 
return_description = "Return the addition of the two numbers in a variable", return_type = DataType.NUMBER, return_required = true)

public class NumberTypeDemo {

	// Add the two number. 
	// Please note that Number attribute always returns as a Double,
	// conversion if needed must be handled in code.
	@Execute
	public NumberValue add(
			@Idx(index = "1", type = AttributeType.NUMBER)
			@Pkg(label = "[[NumberTypeDemo.first.label]]")
			@NotEmpty
			Double first,
			
			@Idx(index = "2", type = AttributeType.NUMBER)
			@Pkg(label = "[[NumberTypeDemo.second.label]]")
			@NotEmpty
			Double second) {
		return new NumberValue(first + second);
	}

}
