/*
 * Copyright (c) 2021 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.GreaterThanEqualTo;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This example demonstrates how to return multiple values from command.
 *
 * @author Jecky.Kansara
 *
 */
@BotCommand
@CommandPkg(name="numberRangeFinder", label = "[[FindMaxMinNumber.label]]",
            description = "[[FindMaxMinNumber.description]]", icon = "pkg.svg",
            node_label ="[[FindMaxMinNumber.node_label]]",
            return_required = true, multiple_returns = {
                    @CommandPkg.Returns(return_label="[[FindMaxMinNumber.return.maximum.label]]", return_name = "maximumNumber", return_type = DataType.NUMBER, return_required = true),
                    @CommandPkg.Returns(return_label="[[FindMaxMinNumber.return.minimum.label]]", return_name = "minimumNumber", return_type = DataType.NUMBER, return_required = true)
                }
            )
public class FindMaxMinNumber {

    @Execute
    public DictionaryValue get(@Idx(index = "1", type = AttributeType.LIST)
                        @Pkg(label = "[[ListTypeDemo.sourceList.label]]")
                        @NotEmpty
                                List<NumberValue> sourceList) {

        double maxValue = Double.MIN_VALUE;
        double minValue = Double.MIN_VALUE;
        for(int index =0; index< sourceList.size(); index++){
            NumberValue numberValue =  (NumberValue)sourceList.get(index );

            if(numberValue.get() > maxValue){
                maxValue =  numberValue.get();
            }

            if(numberValue.get() < minValue){
                minValue = numberValue.get();
            }
        }

        Map<String, Value> returnValue = new HashMap<>();
        returnValue.put("maximumNumber", new NumberValue(maxValue));
        returnValue.put("minimumNumber", new NumberValue(minValue));

        return new DictionaryValue(returnValue);

    }
}
