package com.abhisheksharma.blogapp.blogappbackendapis.services.impl;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Category;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import com.abhisheksharma.blogapp.blogappbackendapis.exceptions.ResourceNotFoundException;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostResponse;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.CategoryRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.PostRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.UserRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PostResponse getAllPosts(Integer pageNumber, Integer pageSize) {
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = this.postRepo.findAll(p);

        List<Post> posts = pagePost.getContent();

        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
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
    public PostResponse getAllPostsByUserId(Integer userId, Integer pageNumber, Integer pageSize) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));

        Pageable p = PageRequest.of(pageNumber,pageSize);

        Page<Post> postPage = this.postRepo.findByUserId(userId, p);

        List<Post> allPosts = postPage.getContent();

        List<PostDto> postDtos = allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalPages(postPage.getTotalPages());
        postResponse.setTotalElements(postPage.getTotalElements());
        postResponse.setLastPage(postPage.isLast());

        return postResponse;

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
