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

import static com.automationanywhere.commandsdk.model.AttributeType.COORDINATE;
import static com.automationanywhere.commandsdk.model.AttributeType.KEYPRESS;

import com.automationanywhere.botcommand.data.model.Point;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * A keypress would type in the provided keys at bot execution.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "KeyPress type demo", 
description = "Shows how to use keypress", icon = "sample.svg", name = "keyPressTypeDemo")
public class KeyPressTypeDemo {
	
	@Execute
	public void typeIn(
		    @Idx(index = "1", type = KEYPRESS)
		    @Pkg(label = "Keypress type")
		    String keyPress
			) {
		
	}

}
