package com.example.nosqldemo.domain;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class Pizza {

	private ObjectId id;
	private boolean sold;
	private double price;
	private String name;
	private int diameter;
	
	private List<Addon> addons = new ArrayList<Addon>();
	

	public ObjectId getId() {
		return this.id;
	}
	
	public void setId(ObjectId id) {
		this.id=id;
	}
	
	public boolean getSold() {
		return this.sold;
	}
	
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDiameter() {
		return this.diameter;
	}
	
	public void setDiameter(int shots) {
		this.diameter = shots;
	}
//	
	public void addAddon(Addon input) {
		this.addons.add(input);
	}
        
	public void setAddom(List<Addon> input) {
		this.addons = input;
	}
	
	public List<Addon> getAddon() {
		return this.addons;
	}
	
}
