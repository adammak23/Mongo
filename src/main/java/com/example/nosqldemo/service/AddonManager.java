/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nosqldemo.service;

import com.example.nosqldemo.domain.Addon;
import com.example.nosqldemo.repository.AddonRepository;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddonManager {
    	@Autowired
	private  AddonRepository addonRepository;
        
        public void add(Addon addon) {
            this.addonRepository.save(addon);
        }
        
        public void clear() {
            this.addonRepository.deleteAll();
        }
        
        public List<Addon> getAddon(String make){
		return addonRepository.findByName(make);
	}
	
	
	public Addon getCar(ObjectId id){
		return addonRepository.findById(id);
	}
        
        public void remove(Addon item) {
            addonRepository.delete(item);
        }
        
        public Iterable<Addon> getAll() {
            return addonRepository.findAll();
        }
}
