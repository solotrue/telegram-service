package org.solotrue.telegramservice.service;

import org.solotrue.telegramservice.repository.TelegramUserMessageRepository;
import org.solotrue.telegramservice.repository.entity.TelegramUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelegramUserMessageServiceImpl implements TelegramUserMessageService {
    private final TelegramUserMessageRepository telegramUserMessageRepository;

    @Autowired
    public TelegramUserMessageServiceImpl(TelegramUserMessageRepository telegramUserMessageRepository) {
        this.telegramUserMessageRepository = telegramUserMessageRepository;
    }

    @Override
    public void save(TelegramUserMessage telegramUserMessage) {
        telegramUserMessageRepository.save(telegramUserMessage);
    }

    @Override
    public Optional<TelegramUserMessage> findById(Long id) {
        return telegramUserMessageRepository.findById(id);
    }

    @Override
    public List<TelegramUserMessage> findAllByChatId(Long chatId) {
        return telegramUserMessageRepository.findAllByChatIdOrderByTimeDesc(chatId);
    }
}

