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
package com.automationanywhere.botcommand.samples.commands.basic;

import static com.automationanywhere.commandsdk.model.AttributeType.RADIO;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.VariableType;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * 
 * In this example we create simple action with multiple choices. The UI would
 * differ based on the the options selected.
 * <p>
 * As a use case we will display a drop down of two cuisine. Based on the
 * country a choice of dishes to order will be presented.
 * <p>
 * Note: 
 * <p>
 * Take a good look at index for creation of hierarchy.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(node_label = "Selecting dishes from | {{cuisine}} |", label = "Hierarchy Demo", 
description = "Example showcasing how to create heierchical UI", name = "hierarchyDemo")

public class HierarchyDemo {
	
	@Execute
	public void getOrder(
		//Add the cuisine	
		@Idx(index = "1", type = AttributeType.SELECT, options = {
				//Check the index of options. TO make them child we add a "." after parent index and start the indexing from 1.
			@Idx.Option(index = "1.1", pkg = @Pkg(label = "Italian", value = "ITALIAN")), 
			@Idx.Option(index = "1.2", pkg = @Pkg(label = "Indian", value = "INDIAN"))})
		@Pkg(label = "Please select a cuisine", description = "", default_value = "ITALIAN", default_value_type = STRING)
		@NotEmpty
		String cuisine,
		
		//Present the italian dishes
		//Check the index, its 1.1.1 meaning it would presented when 1.1 is selected
		@Idx(index = "1.1.1", type = AttributeType.SELECT, options = {
			@Idx.Option(index = "1.1.1.1", pkg = @Pkg(label = "Pizza", value = "PIZZA")), 
			@Idx.Option(index = "1.1.1.2", pkg = @Pkg(label = "Pasta", value = "PASTA"))})
		@Pkg(label = "Please select an Italian dish", description = "", default_value = "PIZZA", default_value_type = STRING)
		@NotEmpty
		String italianDish,
		
		//For varity we are asking the user to input the Indian dish in atextbox
		@Idx(index = "1.2.1", type = AttributeType.TEXT)
	    @Pkg(label = "Please provide and Indian dish")
	    @NotEmpty
	    String indianDish
		
			) {
		
		String dish = "";
		switch(cuisine) {
		case "ITALIAN":
			dish = italianDish;
			break;
		case "INDIAN" :
			dish = indianDish;
			break;
		
		}
		
		// Do something 

	}

}
