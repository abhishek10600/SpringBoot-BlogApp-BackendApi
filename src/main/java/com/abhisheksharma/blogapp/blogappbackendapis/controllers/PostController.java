package com.abhisheksharma.blogapp.blogappbackendapis.controllers;

import com.abhisheksharma.blogapp.blogappbackendapis.payloads.ApiResponse;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;
import com.abhisheksharma.blogapp.blogappbackendapis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/posts/all")
    ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> posts = this.postService.getAllPosts();
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(post, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getAllPostsByUserId(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    ResponseEntity<List<PostDto>> getPostsByCategoryId(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getAllPostsByCategoryId(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @PutMapping("/posts/update/{postId}")
    ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/delete/{postId}")
    ResponseEntity<?> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully", true), HttpStatus.OK);
    }
}
