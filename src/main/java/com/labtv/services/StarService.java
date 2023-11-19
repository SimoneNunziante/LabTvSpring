package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Star;

public interface StarService {

	void saveStar(Star star);
	List<Star>getStars();
	Star getStarById(int id);
	void updateStar(Star star);
	ObjectNode deleteStarById(int id);
	void deleteStar(Star star);
}
