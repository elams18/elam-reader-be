package com.be.elamreader.Repositories;

import com.be.elamreader.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookByBookId(UUID bookId);
    Book deleteBookByBookId(UUID bookId);

    List<Book> deleteBooksByReaderId(UUID readerId);

}
