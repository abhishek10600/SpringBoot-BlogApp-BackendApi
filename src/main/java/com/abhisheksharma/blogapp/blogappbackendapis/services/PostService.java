package com.abhisheksharma.blogapp.blogappbackendapis.services;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    List<PostDto> getAllPosts();

    PostDto getPostById(Integer postId);

    //get all posts by categories
    List<PostDto> getAllPostsByCategoryId(Integer categoryId);

    //get all posts by users
    List<PostDto> getAllPostsByUserId(Integer userId);

    //search posts
    List<Post> searchPosts(String keyword);

    //update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

}
