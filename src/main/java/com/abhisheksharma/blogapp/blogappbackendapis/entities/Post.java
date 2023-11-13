package com.abhisheksharma.blogapp.blogappbackendapis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "title", length = 100, nullable = false)
    private String postTitle;

    @Column(name = "content", length = 10000, nullable = false)
    private String postContent;

    @Column(name = "imageName")
    private String postImageName;

    @Column(name = "createdAt")
    private Date postCreatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;
}
