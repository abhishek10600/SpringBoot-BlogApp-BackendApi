package com.abhisheksharma.blogapp.blogappbackendapis.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    @NotEmpty
    private String postTitle;

    @NotEmpty
    private String postContent;

    private String postImageName;
    private Date postCreatedAt;
    private CategoryDto category;
    private UserDto user;
}
