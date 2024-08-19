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
import com.automationanywhere.botcommand.data.impl.BooleanValue;
import com.automationanywhere.botcommand.data.impl.StringValue;

import com.automationanywhere.botcommand.data.model.SelectItem;
import com.automationanywhere.commandsdk.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;


@BotCommand(commandType = BotCommand.CommandType.DesktopOperationButton)
@CommandPkg(name = "DesktopOperationButtonSample")
public class DesktopOperationButtonSampleClass{


     @DesktopOperationsButtonExecute
     public Map<String, Value> execute(Map<String, Value> input) {
         var retVal = new HashMap<String, Value>();
         retVal.put("optionName", new StringValue("input count: " + Integer.toString(input.size())));
         if(input.containsKey("optionName") && input.containsKey("optionCode") && input.containsKey("aBooleanTypeAttribute")){
             retVal.put( "optionName", new StringValue("Processed : "  +  input.get("optionCode").get().toString()));
             retVal.put( "optionCode", new StringValue( "Processed : " +  input.get("optionName").get().toString()));
             if(input.get("optionName").get().toString().toLowerCase().equals("true")){
                 retVal.put("aBooleanTypeAttribute", new BooleanValue(false));
             }else{
                 retVal.put("aBooleanTypeAttribute", new BooleanValue(true));
             }
         }
         return retVal;
    }
}
