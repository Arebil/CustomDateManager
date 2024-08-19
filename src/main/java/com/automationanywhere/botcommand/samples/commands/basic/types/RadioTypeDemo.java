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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

/**
 * 
 * This example shows how to create a radio group with predefined values.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[RadioTypeDemo.label]]", 
description = "[[RadioTypeDemo.description]]", icon = "sample.svg", name = "radioTypeDemo")
public class RadioTypeDemo {

	private static Logger logger = LogManager.getLogger(RadioTypeDemo.class);
	
	@Execute
	public void getRegionValue(@Idx(index = "1", type = AttributeType.RADIO, options = {
			@Idx.Option(index = "1.1", pkg = @Pkg(label = "[[RadioTypeDemo.region.1.1.label]]", value = "us_east")),
			@Idx.Option(index = "1.2", pkg = @Pkg(label = "[[RadioTypeDemo.region.1.2.label]]", value = "us_west")),
			@Idx.Option(index = "1.3", pkg = @Pkg(label = "[[RadioTypeDemo.region.1.3.label]]", value = "us_central"))
	})
	@Pkg(label = "[[RadioTypeDemo.region.label]]")
	@NotEmpty
	String region) {
		logger.info("Selected region is {}", region);
	}

}
