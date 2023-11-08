package com.abhisheksharma.blogapp.blogappbackendapis.repositories;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
