package org.example.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.example.catsgram.exception.InvalidParam;
import org.example.catsgram.exception.NotFoundedException;
import org.example.catsgram.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>() {{
        add(new Post(1, "bob@mail.com", LocalDate.of(2025, 11, 15), "описание", "url"));
        add(new Post(2, "bob@mail.com", LocalDate.of(2025, 11, 16), "описание", "url"));
        add(new Post(3, "bob@mail.com", LocalDate.of(2025, 11, 17), "описание", "url"));
        add(new Post(4, "bob@mail.com", LocalDate.of(2025, 11, 15), "описание", "url"));
        add(new Post(5, "bob@mail.com", LocalDate.of(2025, 11, 15), "описание", "url"));
        add(new Post(6, "jack@mail.com", LocalDate.of(2025, 11, 15), "описание", "url"));
        add(new Post(7, "jack@mail.com", LocalDate.of(2025, 11, 16), "описание", "url"));
    }};
    private int nextId;

    public Post create(Post post) {
        if (post.getAuthor() == null) {
            log.warn("Автор не может быть пустым");
            throw new InvalidParam("Автор не может быть пустым");
        }
        post.setId(++nextId);
        posts.add(post);
        return post;
    }

    public List<Post> getAllPosts(String author, LocalDate date) {
        if (author == null) {
            return posts;
        }

        return posts.stream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(post -> post.getDate().equals(date))
                .toList();
    }

    public Post getById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new NotFoundedException("Пост по id=" + postId + " не найден"));
    }
}
