package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
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

public final class BapiworkflowTypeDemoCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(BapiworkflowTypeDemoCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    BapiworkflowTypeDemo command = new BapiworkflowTypeDemo();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("parameters") && parameters.get("parameters") != null && parameters.get("parameters").get() != null) {
      convertedParameters.put("parameters", parameters.get("parameters").get());
      if(convertedParameters.get("parameters") !=null && !(convertedParameters.get("parameters") instanceof Map)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","parameters", "Map", parameters.get("parameters").get().getClass().getSimpleName()));
      }
    }
    try {
      command.setParameters( (Map<String, Value>)convertedParameters.get("parameters"));
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.ClassCastException","parameters", "Map<String, Value>", parameters.get("parameters") != null ? (parameters.get("parameters").get() != null ? parameters.get("parameters").get().getClass().toString() : "null") : "null"),e);
    }

    if(parameters.containsKey("parameters1") && parameters.get("parameters1") != null && parameters.get("parameters1").get() != null) {
      convertedParameters.put("parameters1", parameters.get("parameters1").get());
      if(convertedParameters.get("parameters1") !=null && !(convertedParameters.get("parameters1") instanceof Map)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","parameters1", "Map", parameters.get("parameters1").get().getClass().getSimpleName()));
      }
    }
    try {
      command.setParameters1( (Map<String, Value>)convertedParameters.get("parameters1"));
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.ClassCastException","parameters1", "Map<String, Value>", parameters.get("parameters1") != null ? (parameters.get("parameters1").get() != null ? parameters.get("parameters1").get().getClass().toString() : "null") : "null"),e);
    }

    try {
      command.execute();Optional<Value> result = Optional.empty();
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","execute"));
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
