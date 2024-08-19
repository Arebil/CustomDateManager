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
import com.automationanywhere.botcommand.data.model.SelectItem;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.DesktopOperationsSelectExecute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@BotCommand(commandType = BotCommand.CommandType.DesktopOperationSelect)
@CommandPkg(name = "DesktopOperationSelectSample")
public class DesktopOperationSelectSampleClass {
    private static final Logger logger = LogManager.getLogger(DesktopOperationSelectSampleClass.class);

    @DesktopOperationsSelectExecute
    public List<SelectItem> execute(Map<String, Value> input) {
        List<SelectItem> retVal = new ArrayList<>();
        retVal.add(new SelectItem("input count: " + Integer.toString(input.size()), "Code001") );

        if(input.containsKey("optionName") && input.containsKey("optionCode") && input.containsKey("aBooleanTypeAttribute")){
            retVal.add( new SelectItem( input.get("optionName").get().toString(), input.get("optionCode").get().toString()));
            retVal.add( new SelectItem( input.get("optionCode").get().toString(), input.get("optionName").get().toString()));
            retVal.add( new SelectItem( input.get("aBooleanTypeAttribute").get().toString(), "aBooleanTypeAttribute"));
        }
        return retVal;
    }
}

