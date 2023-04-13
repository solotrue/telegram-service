package org.solotrue.telegramservice.bot.keyboard;

import org.solotrue.telegramservice.bot.command.HasCallbackData;

public class InlineKeyboardButtonInfo implements HasCallbackData {
    private final String text;
    private final String callbackData;

    public InlineKeyboardButtonInfo(String text, String callbackData) {
        this.text = text;
        this.callbackData = callbackData;
    }

    public String getCallbackData() {
        return callbackData;
    }

    @Override
    public String getButtonText() {
        return text;
    }
}
