package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Addon;

public interface AddonRepository extends CrudRepository<Addon, ObjectId>{

	@Query(value = "{ 'name' : ?1 }" )
	List<Addon> findByName(String name);
	
	Addon findById(ObjectId id);

}
