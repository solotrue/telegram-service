package org.solotrue.telegramservice.bot.command;

import org.solotrue.telegramservice.repository.entity.TelegramUserMessage;
import org.solotrue.telegramservice.service.SendMessageService;
import org.solotrue.telegramservice.service.TelegramUserMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.getChatId;
import static org.solotrue.telegramservice.bot.command.UtilsCommand.getMessage;

public class CommandMessage implements Command {
    public static final String MESSAGE = "Your message #%s has successfully saved";
    private final SendMessageService sendMessageService;
    private final TelegramUserMessageService telegramUserMessageService;

    public CommandMessage(SendMessageService sendMessageService, TelegramUserMessageService telegramUserMessageService) {
        this.sendMessageService = sendMessageService;
        this.telegramUserMessageService = telegramUserMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        TelegramUserMessage message = new TelegramUserMessage();
        message.setChatId(chatId);
        message.setMessageText(getMessage(update));
        message.setTime(LocalDateTime.now());
        try {
            telegramUserMessageService.save(message);
        } catch (Exception e) {
            //TODO Handle exception
        }
        sendMessageService.sendMessage(getChatId(update), String.format(MESSAGE, message.getId()), null, null, null, null);
    }
}
