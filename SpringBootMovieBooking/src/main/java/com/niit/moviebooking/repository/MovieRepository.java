package com.niit.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.moviebooking.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

}
