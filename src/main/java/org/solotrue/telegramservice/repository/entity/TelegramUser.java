package org.solotrue.telegramservice.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "telegram_user", uniqueConstraints = @UniqueConstraint(columnNames = {"chat_id"}))
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id", unique = true, nullable = false)
    private Long chatId;

    @Column(name = "username")
    private String username;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "register_time", nullable = false)
    private LocalDateTime registerTime;

    @OneToMany(mappedBy = "telegramUser", cascade = CascadeType.ALL)
    private List<TelegramUserMessage> messages = new ArrayList<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TelegramUser that = (TelegramUser) o;
        return getChatId() != null && Objects.equals(getChatId(), that.getChatId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
