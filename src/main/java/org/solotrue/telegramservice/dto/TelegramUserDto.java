package org.solotrue.telegramservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelegramUserDto {
    private Long id;
    private Long chatId;
    private String username;
    private Boolean isActive;
    private LocalDateTime registerTime;
}
