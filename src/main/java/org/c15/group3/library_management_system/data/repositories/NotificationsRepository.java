package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.Abstract.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notification, String> {
}
