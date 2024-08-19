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

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.model.table.Table;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This example shows how to use tables
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "Table type demo", 
description = "Shows how to use a table and accept value from it", icon = "sample.svg", name = "tableTypeDemo", 
return_description = "Return the extracted value in variable", return_type = DataType.ANY)
public class TableTypeDemo {

	@Execute
	public Value printName(
			@Idx(index = "1", type = AttributeType.TABLE)
			@Pkg(label = "Display a table")
			@NotEmpty
			Table table,
			
			@Idx(index = "2", type = AttributeType.NUMBER)
			@Pkg(label = "Enter Row number")
			@NotEmpty
			Double row,
			
			@Idx(index = "3", type = AttributeType.NUMBER)
			@Pkg(label = "Enter Column Number")
			@NotEmpty
			Double col) {
		return table.getRows().get(row.intValue()).getValues().get(col.intValue());
	}
}
