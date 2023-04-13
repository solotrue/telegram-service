package org.solotrue.telegramservice.bot.command;

import org.solotrue.telegramservice.repository.entity.TelegramUser;
import org.solotrue.telegramservice.service.SendMessageService;
import org.solotrue.telegramservice.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.getChatId;

public class CommandStart implements Command {
    public static final String START_MESSAGE = "Activated successfully";
    private final SendMessageService sendMessageService;
    private final TelegramUserService telegramUserService;

    public CommandStart(SendMessageService sendMessageService, TelegramUserService telegramUserService) {
        this.sendMessageService = sendMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUser.setRegisterTime(LocalDateTime.now());
                    telegramUserService.save(telegramUser);
                }
        );
        sendMessageService.sendMessage(chatId, START_MESSAGE, null, null, null, null);
    }
}
