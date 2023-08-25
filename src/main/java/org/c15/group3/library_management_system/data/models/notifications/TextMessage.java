package org.c15.group3.library_management_system.data.models.notifications;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.c15.group3.library_management_system.data.models.Abstract.Notification;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class TextMessage extends Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
