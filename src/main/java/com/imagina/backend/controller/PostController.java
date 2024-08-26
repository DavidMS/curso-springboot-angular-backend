package com.imagina.backend.controller;

import com.imagina.backend.model.dtos.PostDto;
import com.imagina.backend.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostDto addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }

    @PutMapping
    public PostDto updatePost(@RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }
}
