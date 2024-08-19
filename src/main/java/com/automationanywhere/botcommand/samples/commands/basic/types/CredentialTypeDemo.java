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

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.CredentialAllowPassword;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.core.security.SecureString;

/**
 * This example shows how to access Credentials from a AA credential vault and
 * access the values in it. We will access the credential and print it in logs.
 * <p>
 * NOTE: This is for demonstrative purposes only and in actual system sensitive
 * information should never be printed in logs.
 * <p>
 * Credential vault is an AA feature which allows users to store sensitive
 * information in a central repository in encrypted way. It allows users to add
 * upto 50 attributes, and they can be accessed securely in a bot using this
 * mechanism.
 * 
 * @author Raj Singh Sisodia
 *
 */
@BotCommand
@CommandPkg(label = "[[CredentialTypeDemo.label]]", 
description = "[[CredentialTypeDemo.description]]", icon = "sample.svg", name = "credentialTypeDemo")
public class CredentialTypeDemo {

	private static Logger logger = LogManager.getLogger(CredentialTypeDemo.class);

	/**
	 * To accept credentials the {@link AttributeType} in index should be
	 * {@link AttributeType.CREDENTIAL CREDENTIAL}. A {@link SecureString} is
	 * provided for any credentials type.
	 */
	@Execute
	public void printCredentials(@Idx(index = "1", type = AttributeType.CREDENTIAL)
	@Pkg(label = "[[CredentialTypeDemo.credentials.label]]")
	SecureString credentials,

	@Idx(index = "2", type = AttributeType.CREDENTIAL)
	@Pkg(label = "[[CredentialTypeDemo.credentialAllowPasswordAttribute.label]]",
			 description = "This field allow a credential attribute marked as password")
	@CredentialAllowPassword
	SecureString credentialAllowPasswordAttribute) {
		// SecureString provides multiple way to access the data inside.
		// Let's try to get the user name and print it in logs.

		// To get the username as String
		String userName = credentials.getInsecureString();
		logger.trace("User name from getInsecureString : {}", userName);

		// To get the credential as String
		String credential = credentialAllowPasswordAttribute.getInsecureString();
		logger.trace("Credential from getInsecureString : {}", credential);

		// To access passwords securely two options are available. Both methods include
		// providing a Consumer, one of type byte array and the other char array.

		// Lets define the consumers
		Consumer<byte[]> byteArrayPrinter = bytes -> logger.trace("User name from byte array consumer : {}",
				new String(bytes, StandardCharsets.UTF_8));
		Consumer<char[]> charArrayPrinter = chars -> logger.trace("User name from char array consumer : {}",
				new String(chars));

		credentials.access(byteArrayPrinter);
		credentials.accessChars(charArrayPrinter);

	}

}
