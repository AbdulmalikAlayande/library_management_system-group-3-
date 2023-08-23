package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.UserBioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBioDaRepository extends JpaRepository<UserBioData, Long> {
}
