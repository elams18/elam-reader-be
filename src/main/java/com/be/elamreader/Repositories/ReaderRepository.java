package com.be.elamreader.Repositories;

import com.be.elamreader.Models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader getReaderByReaderId(UUID reader_id);

    void deleteReaderByReaderId(UUID reader_id);
}
