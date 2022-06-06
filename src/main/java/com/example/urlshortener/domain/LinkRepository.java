package com.example.urlshortener.domain;

import com.example.urlshortener.domain.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query(value = "call next value for hibernate_sequence", nativeQuery = true)
    Long retrieveNewId();

    Link findByEncoded(String encoded);
}
