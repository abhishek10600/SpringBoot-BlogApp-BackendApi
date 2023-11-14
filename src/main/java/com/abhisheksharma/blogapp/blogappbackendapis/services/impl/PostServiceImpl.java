package com.abhisheksharma.blogapp.blogappbackendapis.services.impl;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Category;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import com.abhisheksharma.blogapp.blogappbackendapis.exceptions.ResourceNotFoundException;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.CategoryRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.PostRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.UserRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl  implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " UserId ", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", " CategoryId ", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setPostImageName("default.png");
        post.setPostCreatedAt(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPostsByCategoryId(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", " CategoryId ", categoryId));
        List<Post> posts =  this.postRepo.findByCategory(category);
        List<PostDto> postDtos =  posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostsByUserId(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostImageName(postDto.getPostImageName());
        Post updatedPost = this.postRepo.save(post);
        PostDto updatedPostDto = this.modelMapper.map(updatedPost, PostDto.class);
        return updatedPostDto;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
        this.postRepo.delete(post);
    }
}
