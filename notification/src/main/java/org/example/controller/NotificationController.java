package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clients.notification.NotificationRequest;
import org.example.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping()
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("sending a notification to {}",notificationRequest);
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok("notification sent to customer with id  = "+notificationRequest.receiver_id());
    }
}
