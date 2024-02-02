package com.be.elamreader.Repositories;

import com.be.elamreader.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
