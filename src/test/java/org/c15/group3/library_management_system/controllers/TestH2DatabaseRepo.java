package org.c15.group3.library_management_system.controllers;

import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2DatabaseRepo extends JpaRepository<TestPojoClass, String> {
}
