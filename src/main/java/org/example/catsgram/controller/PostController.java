package org.example.catsgram.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catsgram.model.Post;
import org.example.catsgram.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    //    @RequestMapping(value = "/posts",method = RequestMethod.GET)
// /posts?author=bob@mail.com
// /posts?author=bob@mail.com&date=2025-11-15
// /posts?date=2025-11-15
// /posts
    @GetMapping("/posts")
    public List<Post> getAllPosts(@RequestParam(required = false) String author,
                                  @RequestParam(required = false) LocalDate date) {
        // ГОД-МЕСЯЦ-ДЕНЬ
        return postService.getAllPosts(author, date);
    }

    @GetMapping("/posts/{postId}")
    public Post getById(@PathVariable int postId) {
        return postService.getById(postId);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.create(post);
    }
//    // переменная пути - Path Variable
}
