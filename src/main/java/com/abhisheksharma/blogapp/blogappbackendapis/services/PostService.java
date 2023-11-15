package com.abhisheksharma.blogapp.blogappbackendapis.services;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    PostDto getPostById(Integer postId);

    //get all posts by categories
    List<PostDto> getAllPostsByCategoryId(Integer categoryId);

    //get all posts by users
    PostResponse getAllPostsByUserId(Integer userId, Integer pageNumber, Integer pageSize);

    //search posts
    List<Post> searchPosts(String keyword);

    //update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

}
