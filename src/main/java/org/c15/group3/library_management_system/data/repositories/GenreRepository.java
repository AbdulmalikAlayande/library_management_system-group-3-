package org.c15.group3.library_management_system.data.repositories;

import org.c15.group3.library_management_system.data.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
