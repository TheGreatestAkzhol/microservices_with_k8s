package com.tomikcode.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "notification_id_sequence")
    private Integer id;
    private String title;
    private String description;
    private String sender;
    private LocalDateTime sentAt;
    private String to_customer_email;
    private Integer to_customer_id;
}
