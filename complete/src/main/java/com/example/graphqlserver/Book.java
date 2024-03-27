package com.example.graphqlserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Book (String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "author-1"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-1"),
            new Book("book-3", "Down Under", 436, "author-3")
    );

    public static Book getById(String id) {
        return books.stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static List<Book> getByAuthorId(String authorId) {
        return books.stream()
                .filter(book -> book.authorId.equals(authorId))
                .collect(Collectors.toList());
    }
    public static int getPageCountByAuthor(String authorId){
        return getByAuthorId(authorId).stream()
                .map(Book::pageCount).mapToInt(Integer::intValue).sum();
    }
    public static List<Book> getAll() {
        return new ArrayList<>(books);
    }

    public static int getTotalPageCount() {
        return books.stream()
                .map(Book::pageCount).mapToInt(Integer::intValue).sum();
    }

    public static Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public static boolean deleteBook(String id) {
        return books.removeIf(book -> book.id.equals(id));
    }
}
