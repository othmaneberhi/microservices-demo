package org.example.model;

import java.time.LocalDateTime;

public record NotificationRequest(String message, String sender, String receiver_email,Integer receiver_id) {
}
