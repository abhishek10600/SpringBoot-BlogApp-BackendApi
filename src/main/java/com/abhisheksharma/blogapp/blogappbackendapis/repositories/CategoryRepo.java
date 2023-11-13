package com.abhisheksharma.blogapp.blogappbackendapis.repositories;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
