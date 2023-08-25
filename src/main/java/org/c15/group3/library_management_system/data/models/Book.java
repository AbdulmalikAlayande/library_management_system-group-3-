package org.c15.group3.library_management_system.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.payment.Price;
import org.c15.group3.library_management_system.data.models.users.Author;
import org.c15.group3.library_management_system.data.models.BookInstance;
import org.c15.group3.library_management_system.data.models.Genre;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;
    private Long isbn;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private LocalDateTime dateAddedToLibrary;
    @Transient
    private Price price;
}
