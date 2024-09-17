package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Trailer;

public interface TrailerService {

	void saveTrailer(Trailer trailer);
	List<Trailer>getTrailers();
	Trailer getTrailerById(int id);
	void updateTrailer(Trailer trailer);
	ObjectNode deleteTrailerById(int id);
	void deleteTrailer(Trailer trailer);
}
