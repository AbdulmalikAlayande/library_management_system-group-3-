package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
