package org.c15.group3.library_management_system.data.models.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.c15.group3.library_management_system.data.models.Abstract.User;
import org.c15.group3.library_management_system.data.models.enums.PaymentMethod;
import org.c15.group3.library_management_system.data.models.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    @OneToOne
    private User payer;
    @OneToOne
    private Receiver receiver;
    private PaymentStatus status;
    private LocalDateTime dateTime;

}
