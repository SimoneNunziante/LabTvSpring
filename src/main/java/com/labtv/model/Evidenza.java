package com.labtv.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evidenza")
public class Evidenza {

	@Id
	@Column(name = "id")
	private String id_evidenza; 
	
	@Column(name = "rank")
	private double rank;
	
	@Column(name = "rankUpDown")
	private String rankUpDown;
	
	@Column(name = "title")
	private String title;
	
	@Column (name = "fullTitle")
	private String fullTitle;
	
	@Column (name = "year")
	private double year;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "crew")
	private String crew;
	
	@Column(name = "imDbRating")
	private String imDbRating;
	
	@Column (name = "imDbRatingCount")
	private String imDbRatingCount;
	
	public String getId() {
		return id_evidenza;
	}
	
	public void setId(String id_evidenza){
		this.id_evidenza=id_evidenza;
	}
	
	public double getRank() {
		return rank;
	}
	
	public void setRank(double rank) {
		this.rank=rank;
	}
	
	public String getRankUpDown() {
		return rankUpDown;
	}
	
	public void setRankUpDown(String rankUpDown) {
		this.rankUpDown=rankUpDown;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getFullTitle() {
		return fullTitle;
	}
	
	public void setFullTitle(String fullTitle) {
		this.fullTitle=fullTitle;
	}
	
	public double getYear() {
		return year;
	}
	
	public void setYear(double year) {
		this.year=year;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image=image;
	}
	
	public String getCrew() {
		return crew;
	}
	
	public void setCrew(String crew) {
		this.crew=crew;
	}
	
	public String getImDbRating() {
		return imDbRating;
	}
	
	public void setImDbRating(String imDbRating) {
		this.imDbRating=imDbRating;
	}
	
	public String getImDbRatingCount() {
		return imDbRatingCount;
	}
	
	public void setImDbRatingCount(String imDbRatingCount) {
		this.imDbRatingCount=imDbRatingCount;
	}
}