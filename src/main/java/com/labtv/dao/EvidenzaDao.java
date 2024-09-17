package com.labtv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.labtv.model.Evidenza;

public interface EvidenzaDao extends CrudRepository<Evidenza, String>{

	@Query(value = "SELECT * FROM evidenza WHERE title LIKE :filmtitle%", nativeQuery = true)
	List<Evidenza>getFilmByTitle(@Param ("filmtitle") String title);
}
