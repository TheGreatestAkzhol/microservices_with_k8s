package com.tomikcode.notification.service;

import com.tomikcode.clients.notification.model.NotificationRequest;
import com.tomikcode.notification.model.Notification;
import com.tomikcode.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest){
        notificationRepository.save(Notification.builder()
                        .description(notificationRequest.getDescription())
                        .title(notificationRequest.getTitle())
                        .sender(notificationRequest.getSender())
                        .to_customer_email(notificationRequest.getTo_customer_email())
                        .to_customer_id(notificationRequest.getTo_customer_id())
                        .sentAt(LocalDateTime.now())
                .build());
    }
}
