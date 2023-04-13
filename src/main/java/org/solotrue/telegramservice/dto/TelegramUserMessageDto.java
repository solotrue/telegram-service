package org.solotrue.telegramservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelegramUserMessageDto {
    private Long id;
    private Long chatId;
    private String messageText;
    private LocalDateTime time;
}
