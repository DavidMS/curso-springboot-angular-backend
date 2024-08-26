package com.imagina.backend.mappers;

import com.imagina.backend.model.dtos.PostDto;
import com.imagina.backend.model.entities.Post;

import java.util.Objects;

public class PostToPostDtoMapper {

    public static PostDto map(Post post) {
        PostDto postDto = null;
        if(Objects.nonNull(post)) {
            postDto = PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .body(post.getBody())
                    .author(post.getAuthor())
                    .build();
        }
        return postDto;
    }
}
