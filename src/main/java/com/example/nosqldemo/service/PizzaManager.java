package com.example.nosqldemo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Pizza;
import com.example.nosqldemo.repository.PizzaRepository;
import com.mongodb.BasicDBObject;

@Component
public class PizzaManager {

	@Autowired
	private  PizzaRepository pizzaRepository;
	
	public void persist(Pizza pizza){
		pizzaRepository.save(pizza);
	}
        
        public void clear() {
            pizzaRepository.deleteAll();
        }
        
	public List<Pizza> getpizzas(String make){
		return pizzaRepository.findByName(make);
	}
	
	
	public Pizza getpizza(ObjectId id){
		return pizzaRepository.findById(id);
	}
	
	public void remove(Pizza pizza) {
            pizzaRepository.delete(pizza);
        }
        
        public Iterable<Pizza> getAll() {
            return pizzaRepository.findAll();
        }
        
        public List<Pizza> findByNameRegex(String regex) {
            return pizzaRepository.findByNameRegex("[A-Z]?"+regex);
        }
}
