package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findByCategory(Category category);
}
