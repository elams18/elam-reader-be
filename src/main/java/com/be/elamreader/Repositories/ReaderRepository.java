package com.be.elamreader.Repositories;

import com.be.elamreader.Models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
