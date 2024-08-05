package com.semicolonafrica.demo.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePostResponse {
    private String id;
    private String title;
    private String content;
}
