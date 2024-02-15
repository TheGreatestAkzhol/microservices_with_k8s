package com.tomikcode.clients.notification;

import com.tomikcode.clients.notification.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        "notification"
)
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void saveNotification(@RequestBody NotificationRequest notificationRequest);
}
//We no longer need it, but it's useful to remember that we used it once
