package org.solotrue.telegramservice.bot.command;

import org.solotrue.telegramservice.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.solotrue.telegramservice.bot.command.UtilsCommand.getChatId;

public class CommandStat implements Command {
    public final static String STAT_MESSAGE = """
            <b>Statistics</b>
            Active users:\s
            Inactive users:\s
            """;
    private final SendMessageService sendMessageService;

    @Autowired
    public CommandStat(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {

        sendMessageService.sendMessage(getChatId(update), STAT_MESSAGE, null, null, null, null);
    }
}