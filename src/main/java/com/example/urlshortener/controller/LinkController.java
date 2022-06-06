package com.example.urlshortener.controller;

import com.example.urlshortener.domain.LinkService;
import com.example.urlshortener.domain.entity.Link;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/links")
    public String registerLink(@RequestParam String target, Model model) {
        log.info("request with link : {}", target);

        Link link = linkService.register(target);

        model.addAttribute("shortened", "http://localhost:8080/" + link.getEncoded());
        model.addAttribute("origUrl", link.getUrl());
        model.addAttribute("createdAt", link.getCreatedAt());

        return "registered";
    }

    @GetMapping("/{encoded}")
    public String redirect(@PathVariable String encoded) {
        String target = linkService.findUrlByEncoded(encoded);

        return "redirect:" + target;
    }

}
