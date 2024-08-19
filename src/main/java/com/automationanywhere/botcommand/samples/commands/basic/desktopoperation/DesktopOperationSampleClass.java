/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

package com.automationanywhere.botcommand.samples.commands.basic.desktopoperation;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

@com.automationanywhere.commandsdk.annotations.BotCommand
@CommandPkg(name = "desktopOperationSample", label = "Desktop Operation Sample" , description = "This Action is created as semple of different variations of Desktop Operation.", node_label = "No label", icon = "desktopoperation.svg", return_type = DataType.STRING)
public class DesktopOperationSampleClass {
    private static final Logger logger = getLogger();

    @Execute
    public Value<?> execute(
            @Idx(index = "1", type = AttributeType.DESKTOPOPERATIONSELECT)
            @Pkg(label = "Desktop Operation Select Attribute" , desktopOperationName = "DesktopOperationSelectSample", desktopOperationAttributeNames = "optionName, optionCode, aBooleanTypeAttribute")
            String desktopOperationSelectAttribute,

	    @Idx(index = "2", type = AttributeType.DESKTOPOPERATIONBUTTON)
            @Pkg(label = "Desktop Operation Button Attribute" , desktopOperationName = "DesktopOperationButtonSample", desktopOperationAttributeNames = "optionName, optionCode, aBooleanTypeAttribute")
            String desktopOperationButtonAttribute,

            @Idx(index = "3", type = AttributeType.TEXT)
            @Pkg(label = "Name to appear in Desktop Operation Select option")
                    String optionName,

            @Idx(index = "4", type = AttributeType.TEXT)
            @Pkg(label = "Code to append in Desktop Operation Select option")
                    String optionCode,

            @Idx(index = "5", type = AttributeType.BOOLEAN)
            @Pkg(label = "A boolean type attribute")
                    Boolean aBooleanTypeAttribute
    )
    {
        return new StringValue(desktopOperationSelectAttribute);
    }
}