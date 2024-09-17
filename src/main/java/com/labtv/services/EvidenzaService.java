package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Evidenza;

public interface EvidenzaService {

	void saveEvidenza(Evidenza evidenza);
	List<Evidenza>getEvidenze();
	Evidenza getEvidenzaById(String id);
	void updateEvidenza(Evidenza evidenza);
	ObjectNode deleteEvidenzaById(String id);
	List<Evidenza>getFilmByTitle(String title);
	void deleteEvidenza(Evidenza evidenza);
}
