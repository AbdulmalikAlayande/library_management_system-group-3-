package org.c15.group3.library_management_system.data.models.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
