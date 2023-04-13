package org.solotrue.telegramservice.service;

import org.solotrue.telegramservice.repository.entity.TelegramUserMessage;

import java.util.List;
import java.util.Optional;

public interface TelegramUserMessageService {
    void save(TelegramUserMessage telegramUserMessage);

    Optional<TelegramUserMessage> findById(Long id);

    List<TelegramUserMessage> findAllByChatId(Long chatId);
}

