package com.tomikcode.clients.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private String title;
    private String description;
    private String sender;
    private String to_customer_email;
    private Integer to_customer_id;
}
