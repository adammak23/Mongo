package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, ObjectId> {
	
	List<Pizza> findByName(String name);
	List<Pizza> findByNameRegex(String name);
	
	Pizza findById(ObjectId id);

}
