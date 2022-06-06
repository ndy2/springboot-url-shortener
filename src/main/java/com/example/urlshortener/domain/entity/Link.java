package com.example.urlshortener.domain.entity;

import com.example.urlshortener.domain.IdEncoder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Link {

    @Id
    private Long id;

    private String encoded;

    private String url;

    private LocalDateTime createdAt;

    public Link(Long id, String url) {
        this.id = id;
        this.url = url;
        this.encoded = IdEncoder.encode(id);
        this.createdAt = now();
    }
}
