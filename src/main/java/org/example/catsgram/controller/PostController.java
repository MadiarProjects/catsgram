package org.example.catsgram.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catsgram.model.Post;
import org.example.catsgram.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
//    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.creat(post);
    }
//public Post getById(int postId) {
//    return posts.stream()
//            .filter(post -> post.getId() == postId)
//            .findFirst()
//            .orElseThrow(() -> new RuntimeException("Пост по id=" + postId + " не найден"));
//}
}
