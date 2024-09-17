package com.labtv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trailer")
public class Trailer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_trailer;
	
	@ManyToOne
	@JoinColumn(name = "id_film", referencedColumnName = "id")
	private Film id_film; 
	
	@Column(name = "video_url")
	private String video_url;
	
	public int getId() {
		return id_trailer;
	}
	
	public void setId(int id_trailer) {
		this.id_trailer=id_trailer;
	}
	
	public Film getId_Film() {
		return id_film;
	}
	
	public void setId_Film(Film id_film) {
		this.id_film=id_film;
	}
	
	public String getVideo_Url() {
		return video_url;
	}
	
	public void setVideo_Url(String video_url) {
		this.video_url=video_url;
	}
	
	
}
