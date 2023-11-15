package com.abhisheksharma.blogapp.blogappbackendapis.repositories;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Category;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByCategory(Category category);
    Page<Post> findByUserId(Integer userId, Pageable pageable);
}
