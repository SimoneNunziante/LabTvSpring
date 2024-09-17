package com.labtv.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_film;
	
	@OneToMany(
			mappedBy = "id_film",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER		
			)
	private List<Trailer>trailers;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "plot")
	private String plot;
	
	@ManyToOne
	@JoinColumn(name = "id_star", referencedColumnName = "id")
	private Star id_star;
	
	@ManyToOne
	@JoinColumn(name = "id_director", referencedColumnName = "id")
	private Director id_director;
	
	@ManyToOne
	@JoinColumn(name = "id_genre", referencedColumnName = "id")
	private Genre id_genre;
	
	@ManyToOne
	@JoinColumn(name = "id_similar", referencedColumnName = "id")
	private Similar id_similar;
	
	public String getId_Film() {
		return id_film;
	}
	
	public void setId_Film(String id_film) {
		this.id_film=id_film;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image=image;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot=plot;
	}
	
	public Star getId_Star() {
		return id_star;
	}
	
	public void setId_Star(Star id_star) {
		this.id_star=id_star;
	}
	
	public Director getId_Director() {
		return id_director;
	}
	
	public void setId_Director(Director id_director) {
		this.id_director=id_director;
	}
	
	public Genre getId_Genre() {
		return id_genre;
	}
	
	public void setId_Genre(Genre id_genre) {
		this.id_genre=id_genre;
	}
	
	public Similar getId_Similar() {
		return id_similar;
	}
	
	public void setId_Similar(Similar id_similar) {
		this.id_similar=id_similar;
	}
	
}
