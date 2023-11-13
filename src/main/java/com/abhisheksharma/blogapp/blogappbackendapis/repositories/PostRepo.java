package com.abhisheksharma.blogapp.blogappbackendapis.repositories;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, Integer> {
}
