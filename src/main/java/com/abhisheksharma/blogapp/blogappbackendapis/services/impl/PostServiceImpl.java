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
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByCategoryId(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }
}
