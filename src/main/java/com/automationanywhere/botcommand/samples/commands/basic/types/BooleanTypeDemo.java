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

import com.automationanywhere.botcommand.data.impl.BooleanValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This example shows how to accept true, false or boolean variable.
 * <p>
 * Inverts the provided boolean value.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[BooleanTypeDemo.label]]", 
description = "[[BooleanTypeDemo.description]]", icon = "sample.svg", name = "booleanTypeDemo", 
return_description = "Return the boolean in variable", return_type = DataType.BOOLEAN, return_required = true)
public class BooleanTypeDemo {

	@Execute
	public BooleanValue invert(@Idx(index = "1", type = AttributeType.BOOLEAN)
	@Pkg(label = "[[BooleanTypeDemo.toInvert.label]]")
	@NotEmpty
	Boolean toInvert) {
		
		return new BooleanValue(!toInvert);
	}
}
