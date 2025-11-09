package org.example.catsgram.controller;

import org.example.catsgram.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private List<Post> posts = new ArrayList<>();
//    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return posts;
    }
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }


}
