package org.example.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.example.catsgram.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();
    public List<Post> getAllPosts(){
        return posts;
    }
    public Post creat(Post post){
        if (post.getAuthor()==null){
            log.warn("автор не может быть пустым");
        }
        posts.add(post);
        return post;
    }
//    // переменная пути - Path Variable
//@GetMapping("/posts/{postId}")
//public Post getById(@PathVariable int postId) {
//    return postService.getById(postId);
//}
}
