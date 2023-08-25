package org.c15.group3.library_management_system.data.models.users;

import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.Abstract.User;
import org.c15.group3.library_management_system.data.models.BookInstance;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
//@Table(name = "authors")
public class Author extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToMany
    private List<BookInstance> booksWritten;
}
