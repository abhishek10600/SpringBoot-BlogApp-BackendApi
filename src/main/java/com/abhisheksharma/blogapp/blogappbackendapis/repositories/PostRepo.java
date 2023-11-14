package com.abhisheksharma.blogapp.blogappbackendapis.repositories;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Category;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
