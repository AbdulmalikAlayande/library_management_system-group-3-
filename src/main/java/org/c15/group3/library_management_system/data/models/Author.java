package org.c15.group3.library_management_system.data.models;

import org.c15.group3.library_management_system.data.models.Abstract.User;

import java.util.List;

public class Author extends User {
    private Long id;
    private List<BookInstance> booksWritten;
}
