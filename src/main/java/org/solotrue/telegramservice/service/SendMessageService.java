package org.solotrue.telegramservice.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SendMessageService {

    void sendMessage(Long chatId, String message, String parseMode, Boolean disableWebPagePreview,
                     Boolean disableNotification, InlineKeyboardMarkup replyMarkup);
}
