package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
