package com.be.elamreader.Controllers;

import com.be.elamreader.Models.Book;
import com.be.elamreader.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    protected BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    protected List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    protected ResponseEntity<?> createBook(@RequestBody Book book){
        if(book.getReader_id() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book does not have a reader");
        }
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
}