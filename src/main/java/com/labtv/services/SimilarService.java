package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Similar;

public interface SimilarService {
	
	void saveSimilar(Similar similar);
	List<Similar>getSimilars();
	Similar getSimilarById(int id);
	void updateSimilar(Similar similar);
	ObjectNode deleteSimilarById(int id);
	void deleteSimilar(Similar similar);
}
