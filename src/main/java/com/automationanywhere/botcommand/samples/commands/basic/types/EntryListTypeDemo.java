/*
 * Copyright (c) 2021 Automation Anywhere.
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

import static com.automationanywhere.commandsdk.model.AttributeType.ENTRYLIST;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.List;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.EntryList.EntryListAddButtonLabel;
import com.automationanywhere.commandsdk.annotations.rules.EntryList.EntryListEmptyLabel;
import com.automationanywhere.commandsdk.annotations.rules.EntryList.EntryListLabel;
import com.automationanywhere.commandsdk.annotations.rules.EntryList.EntryListEntryUnique;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * EntryList provides a mechanism to accept any number of parameters through the
 * bot designer. The structure of the parameter is defined while creating the
 * action.
 * <p>
 * In this example we will create a parameter with name city pair.
 *
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "EntryList demo", description = "EntryList demo", icon = "sample.svg", name = "entryListTypeDemo")

public class EntryListTypeDemo {

	// UI display for ENTRYLIST 1.1, the linking is done based on the title.
	// This should be added as a child of the ENTRYLIST however it should not be part of options.
	// Also this does not need a setter or Inject as the value would be provided inside ENTRYLIST.
	@Idx(index = "1.3", type = TEXT, name = "NAME")
	@Pkg(label = "Name", default_value_type = DataType.STRING)
	@NotEmpty
	private String name;

	//Linked to 1.2 through title.
	@Idx(index = "1.4", type = TEXT, name = "CITY")
	@Pkg(label = "City", default_value_type = STRING)
	private String city;

	@Execute
	public void setParameter(

			// Add the entrylist, the values are accepted as a List of Values.
			// Provide the column header for the tabular display of accepted entries.
			// Take note of the title in Pkg, this value must be unqiue.
			// Also you will need to Idx for each option separately, this step is needed to
			// provide the correct type of UI when the entry form is presented.
			// IMP: Only columns should be added to options, they definitions cannot be added here.
			@Idx(index = "1", type = ENTRYLIST, options = {
					@Idx.Option(index = "1.1", pkg = @Pkg(title = "NAME", label = "Name")),
					@Idx.Option(index = "1.2", pkg = @Pkg(title = "CITY", label = "City")),
			})
			//Label you see at the top of the control
			@Pkg(label = "Provide name value entries")
			//Header of the entry form
			@EntryListLabel(value = "Provide entry")
			//Button label which displays the entry form
			@EntryListAddButtonLabel(value = "Add entry")
			//Uniqueness rule for the column, this value is the TITLE of the column requiring uniqueness. 
			@EntryListEntryUnique(value = "NAME")
			//Message to dispaly in table when no entries are present.
			@EntryListEmptyLabel(value = "No parameters added")
					List<Value> entryList) {

	}

}
