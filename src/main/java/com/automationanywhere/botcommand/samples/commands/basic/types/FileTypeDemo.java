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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.LocalFile;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.RepositoryFile;
import com.automationanywhere.commandsdk.model.AttributeType;

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
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[FileTypeDemo.label]]", 
description = "[[FileTypeDemo.description]]", icon = "sample.svg", name = "fileTypeDemo")
public class FileTypeDemo {
	
	private static Logger logger = LogManager.getLogger(FileTypeDemo.class);
	
	@Execute
	public void accept(@Idx(index = "1", type = AttributeType.FILE)
	@Pkg(label = "[[FileTypeDemo.anyFile.label]]")
	@NotEmpty
	String anyFile,
	
	@Idx(index = "2", type = AttributeType.FILE)
	@Pkg(label = "[[FileTypeDemo.localFile.label]]")
	@NotEmpty
	@LocalFile
	String localFile,
	
	@Idx(index = "3", type = AttributeType.FILE)
	@Pkg(label = "[[FileTypeDemo.repositoryFile.label]]")
	@RepositoryFile("")
	@NotEmpty
	String repositoryFile
			) {
		
		logger.debug("Any file location {}", anyFile);
		logger.debug("Local file location {}", localFile);
		logger.debug("Repository file location {}", repositoryFile);
	}

}
