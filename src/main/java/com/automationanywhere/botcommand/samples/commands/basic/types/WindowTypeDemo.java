/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

package com.automationanywhere.botcommand.samples.commands.basic.types;

import static com.automationanywhere.commandsdk.annotations.BotCommand.CommandType.Condition;
import static com.automationanywhere.commandsdk.model.AttributeType.WINDOW;

import java.time.Duration;

import com.automationanywhere.botcommand.data.impl.WindowValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;

/**
 * 
 * This example shows how to use Window.
 * <p>
 * Here we are checking if a window exists at the bot execution time. Note the
 * current implementation is for windows only and only illustrative and is not
 * accurate.
 * 
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand(commandType = Condition)
@CommandPkg(label = "Window Exists demo", name = "WindowTypeDemo", description = "Checks the boolean variable is false.")
public class WindowTypeDemo {

	@ConditionTest
	public Boolean windowExists(@Idx(index = "1", type = WINDOW)
	@Pkg(label = "Window")
	WindowValue windowValue) {
		long handle = windowValue.findHandle(Duration.ofMillis(50));
		HWND windowHandler = new HWND(Pointer.createConstant(handle));
		return windowHandler != null;
	}
}
