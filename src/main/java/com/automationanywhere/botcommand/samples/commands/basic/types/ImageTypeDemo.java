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
import com.automationanywhere.botcommand.data.model.image.Image;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

/**
 * This example shows how to display a image control and accept value from it.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "Image demo", 
description = "Displays a image control", icon = "sample.svg", name = "imageTypeDemo")
public class ImageTypeDemo {

	
	@Execute
	public void getDate(@Idx(index = "1", type = AttributeType.IMAGE)
	@Pkg(label = "Provide Image")
	@NotEmpty
	Image startDate) {
		
	}
	
}
