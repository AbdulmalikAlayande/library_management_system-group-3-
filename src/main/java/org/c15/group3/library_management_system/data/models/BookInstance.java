package org.c15.group3.library_management_system.data.models;

import org.c15.group3.library_management_system.data.models.Abstract.Book;

import java.time.LocalDateTime;
import java.util.List;

public class BookInstance {
        private Long id;
        private Book book;
        private LocalDateTime dateReturned;
        private LocalDateTime dateBorrowed;
        private List<Customer> customers;
}
