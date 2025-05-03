package com.aatif.book_review_api.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aatif.book_review_api.model.Book;
import com.aatif.book_review_api.repository.BookRepository;
import com.aatif.book_review_api.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testSaveBook() {
        Book book = new Book("Title", "Author", "ISBN", "Description");
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        Book saved = bookService.saveBook(book);
        assertEquals("Title", saved.getTitle());
    }
}   
