package org.solotrue.telegramservice.service;

import org.solotrue.telegramservice.repository.entity.TelegramUser;

import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);

    Optional<TelegramUser> findByChatId(Long chatId);

    Optional<TelegramUser> findByUsername(String username);
}
