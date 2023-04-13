package org.solotrue.telegramservice.service;

import org.solotrue.telegramservice.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    private final TelegramBot bot;

    @Autowired
    public SendMessageServiceImpl(TelegramBot bot) {
        this.bot = bot;
    }


    @Override
    public void sendMessage(Long chatId, String message, String parseMode, Boolean disableWebPagePreview,
                            Boolean disableNotification, InlineKeyboardMarkup replyMarkup) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        if (parseMode == null) {
            parseMode = "html";
        }
        sendMessage.setParseMode(parseMode);

        if (disableWebPagePreview != null) {
            sendMessage.setDisableWebPagePreview(disableWebPagePreview);
        }
        if (disableNotification != null) {
            sendMessage.setDisableNotification(disableNotification);
        }
        if (replyMarkup != null) {
            sendMessage.setReplyMarkup(replyMarkup);
        }

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging
            e.printStackTrace();
        }
    }
}
