package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.StarDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Star;

@Service
public class StarServiceImpl implements StarService{

	@Autowired
	private StarDao stardao;
	
	@Override
	public void saveStar(Star star) {
		stardao.save(star);
	}
	
	@Override
	public List<Star>getStars(){
		ArrayList<Star>stars=(ArrayList<Star>)stardao.findAll();
		return stars;
	}
	
	@Override
	public Star getStarById(int id) {
		return stardao.findById(id).get();
	}
	
	@Override
	public void updateStar(Star star) {
		stardao.save(star);
	}
	
	@Override
	public ObjectNode deleteStarById(int id) {
		Optional<Star>starOptional=stardao.findById(id);
		if(!starOptional.isPresent()) {
			return new ResponseManager(404, "star not found").getResponse();
		}
		else {
			stardao.delete(starOptional.get());
			return new ResponseManager(202, "star deleted").getResponse();
		}
	}
	
	@Override
	public void deleteStar(Star star) {
		stardao.delete(star);
	}
}
