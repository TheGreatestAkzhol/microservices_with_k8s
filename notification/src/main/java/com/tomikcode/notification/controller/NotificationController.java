package com.tomikcode.notification.controller;

import com.tomikcode.clients.notification.model.NotificationRequest;
import com.tomikcode.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/notification")
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void saveNotification(@RequestBody NotificationRequest notificationRequest){
        notificationService.sendNotification(notificationRequest);
        log.info("Notification has been successfully sent {}",notificationRequest);
    }
}
