package com.anbar.employeeaccess.factory;

public class SmsNotification implements Notification {
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}