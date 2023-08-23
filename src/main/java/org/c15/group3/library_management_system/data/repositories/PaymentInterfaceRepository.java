package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.Payer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInterfaceRepository extends JpaRepository <Payer, Long> {
}
