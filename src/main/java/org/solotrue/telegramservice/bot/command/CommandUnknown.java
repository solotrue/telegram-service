package org.solotrue.telegramservice.bot.command;

import org.solotrue.telegramservice.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.getChatId;

public class CommandUnknown implements Command {
    public static final String UNKNOWN_MESSAGE = "Unknown command. Type /help to get list of available commands";
    private final SendMessageService sendMessageService;

    public CommandUnknown(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(getChatId(update), UNKNOWN_MESSAGE, null, null, null, null);
    }
}
