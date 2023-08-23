package org.c15.group3.library_management_system.data.models;

import org.c15.group3.library_management_system.data.models.enums.PaymentMethod;
import org.c15.group3.library_management_system.data.models.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private BigDecimal amount;
    private Long id;
    private PaymentMethod paymentMethod;
    private Payer payer;
    private Receiver receiver;
    private PaymentStatus status;
    private LocalDateTime dateTime;

}
