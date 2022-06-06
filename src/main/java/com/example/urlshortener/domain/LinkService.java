package com.example.urlshortener.domain;

import com.example.urlshortener.domain.entity.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LinkService {

    private final LinkRepository linkRepository;

    public Link register(String url){

        Long id = linkRepository.retrieveNewId();

        //1. 링크 생성
        Link link = new Link(id, url);

        //2. 링크 저장
        return linkRepository.save(link);
    }

    @Transactional(readOnly = true)
    public String findUrlByEncoded(String encoded){
        Link link = linkRepository.findByEncoded(encoded);

        return link.getUrl();
    }
}
