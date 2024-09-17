package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.EvidenzaDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Evidenza;

@Service
public class EvidenzaServiceImpl implements EvidenzaService{

	@Autowired
	private EvidenzaDao evidenzadao;
	
	@Override
	public void saveEvidenza(Evidenza evidenza) {
		evidenzadao.save(evidenza);
	}
	
	@Override
	public List<Evidenza>getEvidenze(){
		ArrayList<Evidenza>evidenze=(ArrayList<Evidenza>)evidenzadao.findAll();
		return evidenze;
	}
	
	@Override
	public Evidenza getEvidenzaById(String id) {
		return evidenzadao.findById(id).get();
	}
	
	@Override
	public void updateEvidenza(Evidenza evidenza) {
		evidenzadao.save(evidenza);
	}
	
	@Override
	public ObjectNode deleteEvidenzaById(String id) {
		Optional<Evidenza>evidenzaOptional=evidenzadao.findById(id);
		if(!evidenzaOptional.isPresent()) {
			return new ResponseManager(404, "Evidenza not found").getResponse();
		}
		else {
			evidenzadao.delete(evidenzaOptional.get());
			return new ResponseManager(202, "Evidenza deleted").getResponse();
		}
	}
	
	@Override
	public List<Evidenza>getFilmByTitle(String title){
		return evidenzadao.getFilmByTitle(title);
	}
	
	@Override
	public void deleteEvidenza(Evidenza evidenza) {
		evidenzadao.delete(evidenza);
	}
}
