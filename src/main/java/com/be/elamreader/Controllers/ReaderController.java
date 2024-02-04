package com.be.elamreader.Controllers;

import com.be.elamreader.Models.Book;
import com.be.elamreader.Models.Reader;
import com.be.elamreader.Repositories.BookRepository;
import com.be.elamreader.Repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    protected List<Reader> getUsers(){
        System.out.println(this.readerRepository);
        return this.readerRepository.findAll();
    }

    @PostMapping
    protected Reader createUser(@RequestBody Reader reader){
        if(reader.getReaderId() == null){
            reader.setReaderId(new UUID(10, 1));
        }
        this.readerRepository.save(reader);
        return reader;
    }

    @GetMapping("/{readerId}")
    protected Reader getByReaderID(@PathVariable UUID readerId){
        return readerRepository.getReaderByReaderId(readerId);
    }

    @DeleteMapping("/{readerId}")
    protected ResponseEntity<?> deleteReaderByReaderID(@PathVariable UUID readerId){
        try {
            if(readerRepository.getReaderByReaderId(readerId) == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reader not found");
            }
            readerRepository.deleteReaderByReaderId(readerId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reader deleted" );
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting reader"+e.getMessage());
        }
    }
}
