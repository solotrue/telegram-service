package org.solotrue.telegramservice.repository;

import org.solotrue.telegramservice.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    Optional<TelegramUser> findByChatId(Long chatId);

    Optional<TelegramUser> findByUsername(String username);
}
