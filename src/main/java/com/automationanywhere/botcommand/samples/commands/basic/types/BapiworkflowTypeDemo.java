/*
 * Copyright (c) 2021 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.sapbapi.Attribute;
import com.automationanywhere.commandsdk.annotations.sapbapi.Entries;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.BapiFieldType;
import com.automationanywhere.commandsdk.model.DataType;

import java.util.Map;

/**
 * This example demonstrates how to use bapi workflow.
 *
 * @author Jecky.Kansara
 *
 */
@BotCommand
@CommandPkg(label = "Bapi workflow demo", name = "bapiworkflow", icon = "sample.svg",description = "[[Bapiworkflow.description]]")
public class BapiworkflowTypeDemo {

    @Idx(index = "1", type = AttributeType.BAPIOBJECT)
    @Pkg()
    @Inject
    Map<String, Value> parameters;

    public void setParameters(Map<String, Value> parameters) {
        this.parameters = parameters;
    }

    public void setParameters1(Map<String, Value> parameters1) {
        this.parameters1 = parameters1;
    }

    @Idx(index = "2", type = AttributeType.BAPIOBJECT)
    @Pkg(default_value_type = DataType.BAPIOBJECT,bapiStructure = @Pkg.BapiWorkflowDefaultValue(
        importParameter = {
                @Attribute(name="IMPORT_SCALAR_PARAMETER", type= BapiFieldType.SCALAR, optional = true, enabled = false),
                @Attribute(name="IMPORT_STRUCTURE_PARAMETER", type= BapiFieldType.STRUCTURE, optional = true, enabled = false,
                    entry = {
                        @Entries(name = "STRUCTURE_FIELD_1", type = "CHAR", optional = true, enabled = false),
                        @Entries(name = "STRUCTURE_FIELD_2", type = "CHAR", optional = true, enabled = true),
                        @Entries(name = "STRUCTURE_FIELD_3", type = "CHAR", optional = false, enabled = true),
                        @Entries(name = "STRUCTURE_FIELD_4", type = "CHAR", optional = false, enabled = false),
                    }
                )
        },
        exportParameter = {
                @Attribute(name="EXPORT_SCALAR_PARAMETER", type= BapiFieldType.SCALAR, optional = true, enabled = false),
                @Attribute(name="EXPORT_STRUCTURE_PARAMETER", type= BapiFieldType.STRUCTURE, optional = true, enabled = false,
                        entry = {
                                @Entries(name = "STRUCTURE_FIELD_1", type = "CHAR", optional = true, enabled = false),
                                @Entries(name = "STRUCTURE_FIELD_2", type = "CHAR", optional = true, enabled = true),
                                @Entries(name = "STRUCTURE_FIELD_3", type = "CHAR", optional = false, enabled = true),
                                @Entries(name = "STRUCTURE_FIELD_4", type = "CHAR", optional = false, enabled = false),
                        }
                )
        },
        tableParameter = {
                @Attribute(name="TABLE_STRUCTURE_PARAMETER", type= BapiFieldType.TABLE, optional = true, enabled = false,
                        entry = {
                                @Entries(name = "STRUCTURE_FIELD_1", type = "CHAR", optional = true, enabled = false),
                                @Entries(name = "STRUCTURE_FIELD_2", type = "CHAR", optional = true, enabled = true),
                                @Entries(name = "STRUCTURE_FIELD_3", type = "CHAR", optional = false, enabled = true),
                                @Entries(name = "STRUCTURE_FIELD_4", type = "CHAR", optional = false, enabled = false),
                        }
                )
        }
    ))
    @Inject
    Map<String, Value> parameters1;


    @Execute
    public void execute(){

    }

}
