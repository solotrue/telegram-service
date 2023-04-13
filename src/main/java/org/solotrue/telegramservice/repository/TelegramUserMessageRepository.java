package org.solotrue.telegramservice.repository;

import org.solotrue.telegramservice.repository.entity.TelegramUserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserMessageRepository extends JpaRepository<TelegramUserMessage, Long> {
    List<TelegramUserMessage> findAllByChatIdOrderByTimeDesc(Long chatId);
}
