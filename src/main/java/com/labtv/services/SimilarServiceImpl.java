package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.SimilarDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Similar;

@Service
public class SimilarServiceImpl implements SimilarService{

	@Autowired
	private SimilarDao similardao;
	
	@Override
	public void saveSimilar(Similar similar) {
		similardao.save(similar);
	}
	
	@Override
	public List<Similar>getSimilars(){
		ArrayList<Similar>similars=(ArrayList<Similar>)similardao.findAll();
		return similars;
	}
	
	@Override
	public Similar getSimilarById(int id) {
		return similardao.findById(id).get();
	}
	
	@Override
	public void updateSimilar(Similar similar) {
		similardao.save(similar);
	}
	
	@Override
	public ObjectNode deleteSimilarById(int id) {
		Optional<Similar>similarOptional=similardao.findById(id);
		if(!similarOptional.isPresent()) {
			return new ResponseManager(404, "similar not found").getResponse();
		}
		else {
			similardao.delete(similarOptional.get());
			return new ResponseManager(202, "similar deleted").getResponse();
		}
	}
	
	@Override
	public void deleteSimilar(Similar similar) {
		similardao.delete(similar);
	}
}
