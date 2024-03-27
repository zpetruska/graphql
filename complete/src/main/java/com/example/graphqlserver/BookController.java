package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @QueryMapping
    public BooksAndTotal allBooks() {return BooksAndTotal.getAllBooks();}

    @QueryMapping
    public BooksAndTotal booksByAuthor(@Argument String authorId) {
        return BooksAndTotal.getAllBooksByAuthor(authorId);
    }

    @MutationMapping
    public Book addBook(@Argument Book book) {
        return Book.addBook(book);
    }

}