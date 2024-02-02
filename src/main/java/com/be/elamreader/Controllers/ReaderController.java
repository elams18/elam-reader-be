package com.be.elamreader.Controllers;

import com.be.elamreader.Models.Reader;
import com.be.elamreader.Repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderRepository readerRepository;
    @GetMapping
    protected List<Reader> getUsers(){
        System.out.println(this.readerRepository);
        return this.readerRepository.findAll();
    }

    @PostMapping
    protected Reader createUser(@RequestBody Reader reader){
        if(reader.getReader_id() == null){
            reader.setReader_id(new UUID(10, 1));
        }
        this.readerRepository.save(reader);
        return reader;
    }

}
