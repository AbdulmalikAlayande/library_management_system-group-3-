package org.c15.group3.library_management_system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<org.c15.group3.library_management_system.data.models.Abstract.Book, Long> {
}
