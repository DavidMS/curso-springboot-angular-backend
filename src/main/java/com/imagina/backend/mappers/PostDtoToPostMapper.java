package com.imagina.backend.mappers;

import com.imagina.backend.model.dtos.PostDto;
import com.imagina.backend.model.entities.Post;

import java.util.Objects;

public class PostDtoToPostMapper {

    public static Post map(PostDto postDto) {
        Post post = null;
        if(Objects.nonNull(postDto)) {
            post = Post.builder()
                    .title(postDto.getTitle())
                    .body(postDto.getBody())
                    .author(postDto.getAuthor())
                    .build();
        }
        return post;
    }
}
