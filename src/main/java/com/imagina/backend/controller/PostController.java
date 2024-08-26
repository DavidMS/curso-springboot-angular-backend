package com.imagina.backend.controller;

import com.imagina.backend.model.dtos.PostDto;
import com.imagina.backend.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @Value("${app.cors.allowedOrigins}")
    private String allowedOrigins;


    @CrossOrigin(origins = "${app.cors.allowedOrigins}")
    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getPosts();
    }

    @CrossOrigin(origins = "${app.cors.allowedOrigins}")
    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @CrossOrigin(origins = "${app.cors.allowedOrigins}")
    @PostMapping
    public PostDto addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @CrossOrigin(origins = "${app.cors.allowedOrigins}")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

    @CrossOrigin(origins = "${app.cors.allowedOrigins}")
    @PutMapping
    public PostDto updatePost(@RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }
}
