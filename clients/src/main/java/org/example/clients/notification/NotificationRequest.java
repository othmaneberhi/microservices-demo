package org.example.clients.notification;

public record NotificationRequest(String message, String sender, String receiver_email, Integer receiver_id) {
}
