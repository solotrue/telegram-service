package org.solotrue.telegramservice.bot.command;

import com.google.common.collect.ImmutableMap;
import org.solotrue.telegramservice.service.SendMessageService;
import org.solotrue.telegramservice.service.TelegramUserMessageService;
import org.solotrue.telegramservice.service.TelegramUserService;

import static org.solotrue.telegramservice.bot.command.CommandName.*;

public class ContainerCommand {
    private final ImmutableMap<String, Command> commandImmutableMap;
    private final Command commandUnknown;

    public ContainerCommand(SendMessageService sendMessageService,
                            TelegramUserService telegramUserService,
                            TelegramUserMessageService telegramUserMessageService) {
        commandImmutableMap = ImmutableMap.<String, Command>builder()
                .put(START.getCallbackData(), new CommandStart(sendMessageService, telegramUserService))
                .put(HELP.getCallbackData(), new CommandHelp(sendMessageService))
                .put(STAT.getCallbackData(), new CommandStat(sendMessageService))
                .put(MESSAGE.getCallbackData(), new CommandMessage(sendMessageService, telegramUserMessageService))
                .build();

        commandUnknown = new CommandUnknown(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        Command command = commandImmutableMap.getOrDefault(commandIdentifier, commandUnknown);
        if (command == null) {
            return commandUnknown;
        }
        return command;
    }

}
