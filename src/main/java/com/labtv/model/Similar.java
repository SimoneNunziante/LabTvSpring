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
@Table(name = "similar")
public class Similar {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_similar;
	
	@OneToMany(
			mappedBy = "id_similar",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Film>film=new ArrayList<>();
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "plot")
	private String plot;
	
	public int getId() {
		return id_similar;
	}
	
	public void setId(int id_similar) {
		this.id_similar=id_similar;
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
	
}
