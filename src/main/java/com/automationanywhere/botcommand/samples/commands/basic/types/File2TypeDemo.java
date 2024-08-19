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

import com.automationanywhere.botcommand.data.impl.FileValue;
import com.automationanywhere.botcommand.data.model.regex.RegexFile;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.LocalFile;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.RepositoryFile;
import com.automationanywhere.commandsdk.model.AttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * This example shows how to accept files.
 * <p>
 * Files can be accepted from local as well as CR. They can be limited to accept
 * from either or both.
 * <p>
 * In this example we are not returning any value but it remains the same as
 * with any other data type.
 * <p>
 * Please note that the attribute FILE returns a String, which is a fully
 * qualified local path. For repository file, it is first downloaded to the
 * local system and then the local path is returned.
 *
 *
 * @author Mahendra
 *
 */
@BotCommand
@CommandPkg(label = "[[File2TypeDemo.label]]",
		description = "[[File2TypeDemo.description]]", icon = "sample.svg", name = "file2TypeDemo")
public class File2TypeDemo {

	private static Logger logger = LogManager.getLogger(File2TypeDemo.class);

	@Execute
	public void regexFile(
			@Idx(index = "1", type = AttributeType.FILE2)
			@Pkg(label = "[[File2TypeDemo.localFile.label]]")
			@NotEmpty
			@LocalFile
					FileValue fileValue)
	{
		if (fileValue.isRegex()) {

			RegexFile regexFile = fileValue.getRegex();
			logger.debug("folder name {}", regexFile.getFolder());
			logger.debug("local file location {}", regexFile.getFileNamePattern().toString());
		}
		else {
			logger.debug("Regex option is not selected");
		}
	}


}
