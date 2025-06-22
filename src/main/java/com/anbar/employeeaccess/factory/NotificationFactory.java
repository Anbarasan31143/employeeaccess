package com.anbar.employeeaccess.factory;

public class NotificationFactory {
    public static Notification getNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type");
        };
    }
}