package com.christian.dojos_and_ninjas.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.christian.dojos_and_ninjas.models.*;
import com.christian.dojos_and_ninjas.repositories.*;

@Service
public class Dojos_And_NinjasService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public Dojos_And_NinjasService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}
	// SELECT * FROM " " WHERE id
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	// INSERT INTO
	public void createNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	public void createDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
}
