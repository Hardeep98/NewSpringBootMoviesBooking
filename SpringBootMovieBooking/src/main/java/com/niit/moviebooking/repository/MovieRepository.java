package com.niit.moviebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niit.moviebooking.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

	@Query(value="SELECT * FROM movies m WHERE m.movie_name like %:name%",nativeQuery = true)
	public List<Movies> fetchMovieName(@Param("name") String name);
	/*  */
}
