package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
