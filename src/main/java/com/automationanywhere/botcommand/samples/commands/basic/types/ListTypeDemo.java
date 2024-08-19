/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
package com.automationanywhere.botcommand.samples.commands.basic.types;

import java.util.List;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.GreaterThanEqualTo;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

@BotCommand
@CommandPkg(label = "[[ListTypeDemo.label]]",
description = "[[ListTypeDemo.description]]", icon = "sample.svg", name = "ListTypeDemo", 
return_description = "Return the value in variable", return_type = DataType.ANY, return_required = true)
public class ListTypeDemo {
	@SuppressWarnings("rawtypes")
	@Execute
	public Value<?> get(@Idx(index = "1", type = AttributeType.LIST)
	@Pkg(label = "[[ListTypeDemo.sourceList.label]]")
	@NotEmpty
	List<Value> sourceList,

			@Idx(index = "2", type = AttributeType.NUMBER)
			@Pkg(label = "[[ListTypeDemo.itemPositionNumber.label]]")
			@GreaterThanEqualTo("0")
			@NotEmpty
			Double itemPositionNumber) {
		return sourceList.get(itemPositionNumber.intValue());
	}
}
