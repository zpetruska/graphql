package com.example.graphqlserver;

import java.util.List;

public record BooksAndTotal(List<Book> books, int totalPages) {

    public static BooksAndTotal getAllBooks() {
        return new BooksAndTotal(Book.getAll(), Book.getTotalPageCount());
    }

    public static BooksAndTotal getAllBooksByAuthor(String id) {
        return new BooksAndTotal(Book.getByAuthorId(id), Book.getPageCountByAuthor(id));
    }
}
