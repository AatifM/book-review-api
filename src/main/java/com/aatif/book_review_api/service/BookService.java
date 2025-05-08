package com.aatif.book_review_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aatif.book_review_api.model.Book;
import com.aatif.book_review_api.repository.BookRepository;

@Service
public class BookService {
    
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + id);    
        }
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
            .map(existingBook -> {
                if (updatedBook.getTitle() != null) existingBook.setTitle(updatedBook.getTitle());
                if (updatedBook.getAuthor() != null) existingBook.setAuthor(updatedBook.getAuthor());
                if (updatedBook.getIsbn() != null) existingBook.setIsbn(updatedBook.getIsbn());
                if (updatedBook.getDescription() != null) existingBook.setDescription(updatedBook.getDescription());
                return bookRepository.save(existingBook); // Save the updated book
            })
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }   
}
