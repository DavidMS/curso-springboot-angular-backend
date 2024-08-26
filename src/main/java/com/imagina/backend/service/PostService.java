package com.imagina.backend.service;

import com.imagina.backend.mappers.PostDtoToPostMapper;
import com.imagina.backend.mappers.PostToPostDtoMapper;
import com.imagina.backend.model.dtos.PostDto;
import com.imagina.backend.model.entities.Post;
import com.imagina.backend.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> PostToPostDtoMapper.map(post))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) {
        return postRepository.findById(id)
                .map(post -> PostToPostDtoMapper.map(post))
                .orElseThrow(NoSuchElementException::new);
    }

    public PostDto addPost(PostDto postDto) {
        return PostToPostDtoMapper
                .map(postRepository.save(PostDtoToPostMapper.map(postDto)));
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        postRepository.delete(post);
    }

    public PostDto updatePost(PostDto postDto) {
        Post post = postRepository.findById(postDto.getId())
                .orElseThrow(NoSuchElementException::new);
        post.setBody(postDto.getBody());
        post.setAuthor(postDto.getAuthor());
        post.setTitle(postDto.getTitle());
        return PostToPostDtoMapper
                .map(postRepository.save(post));
    }
}
