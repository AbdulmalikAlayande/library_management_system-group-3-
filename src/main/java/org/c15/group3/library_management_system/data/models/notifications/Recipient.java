package org.c15.group3.library_management_system.data.models.notifications;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

public class Recipient{
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;
}
