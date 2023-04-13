package org.solotrue.telegramservice.bot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import static org.solotrue.telegramservice.bot.TelegramBot.COMMAND_PREFIX;

public class UtilsCommand {
    public static Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        }
        return null;
    }

    public static String getMessage(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getText().trim();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getData().trim();
        }
        return null;
    }

    public static boolean isCommand(Update update) {
        return update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().startsWith(COMMAND_PREFIX);
    }

    public static boolean isCallbackQuery(Update update) {
        return update.hasCallbackQuery();
    }

}
