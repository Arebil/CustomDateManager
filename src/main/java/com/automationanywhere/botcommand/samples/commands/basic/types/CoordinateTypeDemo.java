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

import java.time.ZonedDateTime;

import com.automationanywhere.botcommand.data.model.Point;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

/**
 * This example shows how to display a datetime control and accept value from it.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "CoordinateTypeDemo demo", 
description = "Displays a date time control", icon = "sample.svg", name = "coordinateTypeDemo")
public class CoordinateTypeDemo {

	
	@Execute
	public void getDate(@Idx(index = "1", type = AttributeType.COORDINATE)
	@Pkg(label = "Provide cordinates")
	@NotEmpty
	Point startDate) {
		
	}
	
}
