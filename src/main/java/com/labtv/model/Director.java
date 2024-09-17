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
@Table(name = "director")
public class Director {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_director;
	
	@OneToMany(
			mappedBy = "id_director",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Film>film= new ArrayList<>();
	
	@Column(name = "director_name")
	private String director_name;
	
	@Column(name = "director_surname")
	private String director_surname;
	
	@Column(name = "director_bio")
	private String director_bio;
	
	public int getId() {
		return id_director;
	}
	
	public void setId(int id_director) {
		this.id_director=id_director;
	}
	
	public String getDirector_Name() {
		return director_name;
	}
	
	public void setDirector_Name(String director_name) {
		this.director_name=director_name;
	}
	
	public String getDirector_Surname() {
		return director_surname;
	}
	
	public void setDirector_Surname(String director_surname) {
		this.director_surname=director_surname;
	}
	
	public String getDirector_Bio() {
		return director_bio;
	}
	
	public void setDirector_Bio(String director_bio) {
		this.director_bio=director_bio;
	}
	
}
