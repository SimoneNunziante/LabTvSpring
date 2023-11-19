package com.labtv.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_genre;
	@OneToMany(
			mappedBy = "id_genre",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Film>film=new ArrayList<>();
	
	@Column(name = "genre_name")
	private String genre_name;
	
	public int getId() {
		return id_genre;
	}
	
	public void setId(int id_genre) {
		this.id_genre=id_genre;
	}
	
	public String getGenre_Name() {
		return genre_name;
	}
	
	public void setGenre_Name(String genre_name) {
		this.genre_name=genre_name;
	}
	
}
