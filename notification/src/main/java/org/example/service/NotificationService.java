package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Notification;
import org.example.model.NotificationRequest;
import org.example.repository.INotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final INotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest){
        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .sender(notificationRequest.sender())
                .sent_at(LocalDateTime.now())
                .receiver_id(notificationRequest.receiver_id())
                .receiver_email(notificationRequest.receiver_email())
                .build();
        notificationRepository.save(notification);
    }
}
