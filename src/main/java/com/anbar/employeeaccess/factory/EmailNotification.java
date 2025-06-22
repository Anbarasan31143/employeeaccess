package com.anbar.employeeaccess.factory;

public class EmailNotification implements Notification {
    public void send(String to, String message) {
        System.out.println("Sending EMAIL to " + to + ": " + message);
    }
}