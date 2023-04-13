package org.solotrue.telegramservice.bot.command;

public enum CommandName implements HasCallbackData {
    START("/start", "Start", false, true),
    STOP("/stop", "Stop", false, true),
    HELP("/help", "Help", false, true),
    MESSAGE("", "", false, false),
    STAT("/stat", "Statistics", true, true);

    private final String callbackData;
    private final String buttonText;
    private final boolean admin;
    private final boolean active;


    CommandName(String callbackData, String buttonText, boolean admin, boolean active) {
        this.callbackData = callbackData;
        this.buttonText = buttonText;
        this.admin = admin;
        this.active = active;
    }

    @Override
    public String getButtonText() {
        return buttonText;
    }

    @Override
    public String getCallbackData() {
        return callbackData;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isActive() {
        return active;
    }
}
