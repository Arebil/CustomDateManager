package com.automationanywhere.botcommand;

import com.automationanywhere.botcommand.data.impl.BooleanValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.time.LocalDate;
import java.util.List;

import static com.automationanywhere.commandsdk.model.AttributeType.LIST;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

//BotCommand makes a class eligible for being considered as an action.
@BotCommand
//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "WorkingDay",
        label = "[[WorkingDay.label]]",
        node_label = "[[WorkingDay.node_label]]",
        description = "[[WorkingDay.description]]",
        icon = "pkg.svg",
        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "[[WorkingDay.return_label]]",
        return_type = BOOLEAN, return_required = true,
        return_description = "[[WorkingDay.return_label_description]]")

public class WorkingDay {
    //Identify the entry point for the action. Returns a NumberValue because the return type is NUMBER.
    @Execute //entry point into the action
    public BooleanValue action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            //first input => inputDate
            @Idx(index = "1", type = TEXT)
            //UI labels.
            @Pkg(label = "[[WorkingDay.inputDate.label]]") //@Pkg(label = "Text type")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty //required field
            String inputDate,

            //second input => String list of holidays
            @Idx(index = "2", type = LIST)
            @Pkg(label = "[[WorkingDay.inputHolidays.label]]") //@Pkg(label = "List type")
            @NotEmpty
            List<String> inputHolidays
    ) {
        try {
            // Parse inputDate string to LocalDate
            LocalDate dateToCheck = new DateOperations().convertToDate(inputDate);
            // Convert list of holiday strings to list of LocalDate objects
            List<LocalDate> holidaysList = new DateOperations().convertToDateList(inputHolidays);

            // Check if the date is a working day
            boolean isWorkingDay = new DateOperations().isWorkingDay(dateToCheck, holidaysList);
            //creating a new instance of the BooleanValue class and passing isWorkingDay as an argument to its constructor
            return new BooleanValue(isWorkingDay);

        } catch (IllegalArgumentException e) {
            // Handle invalid date format or other errors
            throw new BotCommandException("Error: " + e.getMessage(), e);
        }
    }
}