package com.be.elamreader.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Reader {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "reader_id")
    private UUID readerId;

    @Column(name = "reader_name")
    private String readerName;


    public UUID getReaderId() {
        return readerId;
    }

    public void setReaderId(UUID readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }
}
