package com.labtv.dao;

import org.springframework.data.repository.CrudRepository;

import com.labtv.model.Film;

public interface FilmDao extends CrudRepository<Film, String>{

}
