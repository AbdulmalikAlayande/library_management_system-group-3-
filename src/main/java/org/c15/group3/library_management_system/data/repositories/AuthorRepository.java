package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.users.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
