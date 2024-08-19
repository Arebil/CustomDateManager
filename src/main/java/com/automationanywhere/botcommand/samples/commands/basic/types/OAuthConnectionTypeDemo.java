/* Copyright (c) 2023 Automation Anywhere. All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere. You shall use it only in
 * accordance with the terms of the license agreement you entered into with Automation Anywhere.
 */
package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.botcommand.data.model.oauth.OAuthConnection;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This example shows how to access OAuth Connection detail from Control Room and
 * access the values in it. We will access the connection detail and print it in logs.
 * <p>
 * NOTE: This is for demonstrative purposes only and in actual system sensitive
 * information should never be printed in logs.
 *
 */
@BotCommand
@CommandPkg(label = "[[OAuthConnectionTypeDemo.label]]",
description = "[[OAuthConnectionTypeDemo.description]]", icon = "sample.svg", name = "OAuthConnectionTypeDemo",
minimum_controlroom_version = "18002",
minimum_botagent_version = "21.25")
public class OAuthConnectionTypeDemo {

	private static Logger logger = LogManager.getLogger(CredentialTypeDemo.class);

	/**
	 * To accept OAuthConnection the {@link AttributeType} in index should be
	 * {@link AttributeType#OAUTHCONNECTION OAUTHCONNECTION}. A {@link OAuthConnection} is
	 * provided to receive connection detail.
	 */
	@Execute
	public void printOAuthConnectionDetail(
		@Idx(index = "1", type = AttributeType.OAUTHCONNECTION)
		@Pkg(label = "[[OAuthConnectionTypeDemo.connection.label]]")
		@NotEmpty
  		OAuthConnection connection) {
		// OAuthConnection provides getter to access connection detail like url, token, etc.

		logger.trace("OAuth connection id: {}", connection.getId());
		logger.trace("OAuth connection name: {}", connection.getName());
		logger.trace("OAuth connection url: {}", connection.getUrl());
		logger.trace("OAuth connection token: {}", connection.getToken());
	}

}
