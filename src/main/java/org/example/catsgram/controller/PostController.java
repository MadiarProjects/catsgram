package org.example.catsgram.controller;

import org.example.catsgram.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private List<Post> posts = new ArrayList<>();
//    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        logger.debug("текущее количество постов"+posts.size());
        return posts;
    }
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }


}
