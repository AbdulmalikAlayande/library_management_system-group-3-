package org.c15.group3.library_management_system.data.models.Abstract;

import org.c15.group3.library_management_system.data.models.Author;
import org.c15.group3.library_management_system.data.models.BookInstance;
import org.c15.group3.library_management_system.data.models.Genre;

import java.time.LocalDateTime;

public abstract class Book {
    private Long id;
    private Long isbn;
    private String title;
    private Author author;
    private Genre genre;
    private LocalDateTime dateAddedToLibrary;
    private BookInstance bookInstance;
}
