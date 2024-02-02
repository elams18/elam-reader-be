package com.be.elamreader.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Reader {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID reader_id;
    private String reader_name;


    public UUID getReader_id() {
        return reader_id;
    }

    public void setReader_id(UUID reader_id) {
        this.reader_id = reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }
}
