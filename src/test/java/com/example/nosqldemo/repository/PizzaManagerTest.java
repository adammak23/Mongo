package com.example.nosqldemo.repository;

import com.example.nosqldemo.domain.Addon;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Pizza;
import com.example.nosqldemo.service.AddonManager;
import com.example.nosqldemo.service.PizzaManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PizzaManagerTest {
	
	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	AddonManager addonManager;
        
        @After
        @Before
	public void clear() {
		pizzaManager.clear();
                addonManager.clear();
	}
        
        @Before
        public void add() {
                Pizza pizza = new Pizza();
		pizza.setName("Carbonara");
                pizza.setPrice(22);
                pizza.setDiameter(20);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
		pizza=null;
        }
        


}
