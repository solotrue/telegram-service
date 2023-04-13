package org.solotrue.telegramservice.bot;

import org.solotrue.telegramservice.bot.command.ContainerCommand;
import org.solotrue.telegramservice.bot.handlers.CommandHandler;
import org.solotrue.telegramservice.service.SendMessageServiceImpl;
import org.solotrue.telegramservice.service.TelegramUserMessageService;
import org.solotrue.telegramservice.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.isCallbackQuery;
import static org.solotrue.telegramservice.bot.command.UtilsCommand.isCommand;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    private final String botName;
    private final String botToken;
    private final ContainerCommand containerCommand;

    @Autowired
    public TelegramBot(@Value("${telegram.bot.name}")String botName,
                       @Value("${telegram.bot.token}")String botToken,
                       TelegramUserService telegramUserService,
                       TelegramUserMessageService telegramUserMessageService) {
        this.botName = botName;
        this.botToken = botToken;

        this.containerCommand = new ContainerCommand(new SendMessageServiceImpl(this),
                telegramUserService, telegramUserMessageService);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Received update: " + update);

        if (update == null) {
            throw new IllegalArgumentException("Update is null");
        }

        if (isCommand(update)) {
            CommandHandler.handleCommand(containerCommand, update);
        } else if (isCallbackQuery(update)) {
            CommandHandler.handleCallback(containerCommand, update);
        } else {
            throw new IllegalArgumentException("Unsupported update type");
        }
    }
}


