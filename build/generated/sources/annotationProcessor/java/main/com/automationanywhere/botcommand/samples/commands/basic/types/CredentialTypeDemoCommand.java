package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.core.security.SecureString;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CredentialTypeDemoCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(CredentialTypeDemoCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    CredentialTypeDemo command = new CredentialTypeDemo();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("credentials") && parameters.get("credentials") != null && parameters.get("credentials").get() != null) {
      convertedParameters.put("credentials", parameters.get("credentials").get());
      if(convertedParameters.get("credentials") !=null && !(convertedParameters.get("credentials") instanceof SecureString)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","credentials", "SecureString", parameters.get("credentials").get().getClass().getSimpleName()));
      }
    }

    if(parameters.containsKey("credentialAllowPasswordAttribute") && parameters.get("credentialAllowPasswordAttribute") != null && parameters.get("credentialAllowPasswordAttribute").get() != null) {
      convertedParameters.put("credentialAllowPasswordAttribute", parameters.get("credentialAllowPasswordAttribute").get());
      if(convertedParameters.get("credentialAllowPasswordAttribute") !=null && !(convertedParameters.get("credentialAllowPasswordAttribute") instanceof SecureString)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","credentialAllowPasswordAttribute", "SecureString", parameters.get("credentialAllowPasswordAttribute").get().getClass().getSimpleName()));
      }
    }

    try {
      command.printCredentials((SecureString)convertedParameters.get("credentials"),(SecureString)convertedParameters.get("credentialAllowPasswordAttribute"));Optional<Value> result = Optional.empty();
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","printCredentials"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }

  public Map<String, Value> executeAndReturnMany(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return null;
  }
}
