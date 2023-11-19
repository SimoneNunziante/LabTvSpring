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
@Table(name = "star")
public class Star {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_star;
	
	@OneToMany(
			mappedBy = "id_star",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Film>film=new ArrayList<>();
	
	@Column(name = "star_name")
	private String star_name;
	
	@Column(name = "star_surname")
	private String star_surname;
	
	@Column(name = "star_bio")
	private String star_bio;
	
	public int getId() {
		return id_star;
	}
	
	public void setId(int id_star) {
		this.id_star=id_star;
	}
	
	public String getStar_Name() {
		return star_name;
	}
	
	public void setStar_Name(String star_name) {
		this.star_name=star_name;
	}
	
	public String getStar_Surname() {
		return star_surname;
	}
	
	public void setStar_Surname(String star_surname) {
		this.star_surname=star_surname;
	}
	
	public String getStar_Bio() {
		return star_bio;
	}
	
	public void setStar_Bio(String star_bio) {
		this.star_bio=star_bio;
	}
	
	
}
