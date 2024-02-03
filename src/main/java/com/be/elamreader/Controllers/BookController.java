package com.be.elamreader.Controllers;

import com.be.elamreader.Models.Book;
import com.be.elamreader.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        if(book.getReaderId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book does not have a reader");
        }
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/{bookId}")
    protected ResponseEntity<?> getBookbyBookId(@PathVariable UUID bookId){
        Book book = bookRepository.getBookByBookId(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PatchMapping
    protected ResponseEntity<?> updateBook(@RequestBody Book book){
        if(book.getReaderId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book does not have a reader");
        }
        Book updatedBook = bookRepository.getBookByBookId(book.getBookId());
        if (updatedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBook);
    }

    @DeleteMapping("/{bookId}")
    protected ResponseEntity<?> deleteBookbyBookId(@PathVariable UUID bookId){
        Book deletedBook = bookRepository.deleteBookByBookId(bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("book deleted" + deletedBook);
    }
}