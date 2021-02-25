package com.google.common.eventbus;

public class RegNotificationObserver {
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }
}
