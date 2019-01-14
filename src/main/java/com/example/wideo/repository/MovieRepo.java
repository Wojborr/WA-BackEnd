package com.example.wideo.repository;

import com.example.wideo.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
