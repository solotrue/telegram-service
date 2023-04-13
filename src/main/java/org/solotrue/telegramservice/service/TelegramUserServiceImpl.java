package org.solotrue.telegramservice.service;

import org.solotrue.telegramservice.repository.TelegramUserRepository;
import org.solotrue.telegramservice.repository.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {
    private final TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserServiceImpl(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public Optional<TelegramUser> findByChatId(Long chatId) {
        return telegramUserRepository.findByChatId(chatId);
    }

    @Override
    public Optional<TelegramUser> findByUsername(String username) {
        return telegramUserRepository.findByUsername(username);
    }
}

