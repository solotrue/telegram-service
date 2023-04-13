package org.solotrue.telegramservice.bot.handlers;

import org.solotrue.telegramservice.bot.command.ContainerCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.solotrue.telegramservice.bot.TelegramBot.COMMAND_PREFIX;

public class CommandHandler {

    public static void handleCommand(ContainerCommand containerCommand, Update update) {
        String text = update.getMessage().getText().trim();
        System.out.println(text);
        if (text.startsWith(COMMAND_PREFIX)) {
            String commandIdentifier = text.split(" ")[0].toLowerCase();
            containerCommand.retrieveCommand(commandIdentifier).execute(update);
        }
    }

    public static void handleCallback(ContainerCommand command, Update update) {
        {
            String data = update.getCallbackQuery().getData();
            System.out.println(data);
            if (data.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = data.split(" ")[0].toLowerCase();
                command.retrieveCommand(commandIdentifier).execute(update);
            }
        }
    }
}
