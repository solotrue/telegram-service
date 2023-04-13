package org.solotrue.telegramservice.bot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardBuilder {
    private final List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

    public InlineKeyboardBuilder() {
    }

    public static InlineKeyboardBuilder create() {
        return new InlineKeyboardBuilder();
    }

    public void addButton(InlineKeyboardButtonInfo button) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(button.getButtonText());
        inlineKeyboardButton.setCallbackData(button.getCallbackData());
        row.add(inlineKeyboardButton);
        keyboard.add(row);
    }

    public InlineKeyboardBuilder addRow() {
        keyboard.add(new ArrayList<>());
        return this;
    }

    public InlineKeyboardBuilder setColumns(int columns) {
        return this;
    }

    public InlineKeyboardBuilder addCallbackRows(InlineKeyboardButtonInfo[] items) {
        for (InlineKeyboardButtonInfo item : items) {
            addButton(item);
        }
        return this;
    }

    public InlineKeyboardMarkup build() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }


}

