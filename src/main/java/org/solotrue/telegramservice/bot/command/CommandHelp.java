package org.solotrue.telegramservice.bot.command;

import org.solotrue.telegramservice.bot.keyboard.InlineKeyboardBuilder;
import org.solotrue.telegramservice.bot.keyboard.InlineKeyboardButtonInfo;
import org.solotrue.telegramservice.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Arrays;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.getChatId;

public class CommandHelp implements Command {
    public static final String HELP_MESSAGE = "Please select a command:";
    private final SendMessageService sendMessageService;

    public CommandHelp(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        InlineKeyboardMarkup keyboardMarkup = InlineKeyboardBuilder.create()
                .setColumns(1)
                .addCallbackRows(Arrays.stream(CommandName.values())
                        .filter(cmd -> cmd.isActive() && !cmd.isAdmin())
                        .map(cmd -> new InlineKeyboardButtonInfo(cmd.getButtonText(), cmd.getCallbackData()))
                        .toArray(InlineKeyboardButtonInfo[]::new))
                .build();
        sendMessageService.sendMessage(getChatId(update), HELP_MESSAGE, null, null, null, keyboardMarkup);
    }
}
