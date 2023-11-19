package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.TrailerDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Trailer;

@Service
public class TrailerServiceImpl implements TrailerService{

	@Autowired
	private TrailerDao trailerdao;
	
	@Override
	public void saveTrailer(Trailer trailer) {
		trailerdao.save(trailer);
	}
	
	@Override
	public List<Trailer>getTrailers(){
		ArrayList<Trailer>trailers=(ArrayList<Trailer>)trailerdao.findAll();
		return trailers;
	}
	
	@Override
	public Trailer getTrailerById(int id) {
		return trailerdao.findById(id).get();
	}
	
	@Override
	public void updateTrailer(Trailer trailer) {
		trailerdao.save(trailer);
	}
	
	@Override
	public ObjectNode deleteTrailerById(int id) {
		Optional<Trailer>trailerOptional=trailerdao.findById(id);
		if(!trailerOptional.isPresent()) {
			return new ResponseManager(404, "trailer not found").getResponse();
		}
		else {
			trailerdao.delete(trailerOptional.get());
			return new ResponseManager(202, "trailer deleted").getResponse();
		}
	}
	
	@Override
	public void deleteTrailer(Trailer trailer) {
		trailerdao.delete(trailer);;
	}
}
