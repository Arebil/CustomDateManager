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

import java.util.Map;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This example shows how to accept a dictionary and use it.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[DictionaryTypeDemo.label]]", 
description = "[[DictionaryTypeDemo.description]]", icon = "sample.svg", name = "dictionaryTypeDemo", 
return_description = "Return the value in variable", return_type = DataType.ANY, return_required = true)
public class DictionaryTypeDemo {

	@Execute
	public Value extract(@Idx(index = "1", type = AttributeType.DICTIONARY)
	@Pkg(label = "[[DictionaryTypeDemo.keyValuePair.label]]")
	@NotEmpty
	Map<String, Value>  keyValuePair,
	
	@Idx(index = "2", type = AttributeType.TEXT)
	@Pkg(label = "[[DictionaryTypeDemo.key.label]]")
	@NotEmpty
	String key
	) {
		return keyValuePair.get(key);
	}
	
}
