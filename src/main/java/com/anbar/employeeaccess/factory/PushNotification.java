package com.anbar.employeeaccess.factory;

public class PushNotification implements Notification {
    public void send(String to, String message) {
        System.out.println("Sending PUSH notification to " + to + ": " + message);
    }
}