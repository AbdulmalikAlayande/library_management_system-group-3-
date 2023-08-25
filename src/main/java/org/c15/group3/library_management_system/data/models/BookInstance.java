package org.c15.group3.library_management_system.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.users.Customer;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class BookInstance {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        @OneToOne
        private Book book;
        private LocalDateTime dateReturned;
        private LocalDateTime dateBorrowed;
        @OneToMany
        private List<Customer> customers;
}
