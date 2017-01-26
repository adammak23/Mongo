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
        
	@Test
	public void checkAdding(){
                this.clear();
		Pizza pizza = new Pizza();
		pizza.setName("Margerita");
                pizza.setPrice(22);
                pizza.setDiameter(20);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
		pizza=null;
		pizza = new Pizza();
		pizza.setName("Carbonara");
                pizza.setPrice(222);
                pizza.setDiameter(20);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
		pizza=null;
		pizza = new Pizza();
		pizza.setName("Hawajska");
                pizza.setPrice(2222);
                pizza.setDiameter(15);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
		List<Pizza> cars = pizzaManager.getpizzas("Margerita");
		
		assertTrue(cars.size() >= 1);
	}
        
        @Test 
        public void checkingEdit() {
            Pizza pizza = pizzaManager.getpizzas("Carbonara").get(0);
            pizza.setName("Hawajska");
            pizza.setSold(true);
            pizzaManager.persist(pizza);
            pizza = null;
            
            pizza = pizzaManager.getpizzas("Hawajska").get(0);
            assertEquals(pizza.getName(), "Hawajska");
            assertEquals(pizza.getPrice(), 22.0, 0.01);
            assertEquals(pizza.getDiameter(), 20);
            assertEquals(pizza.getSold(), true);
        }
        
        @Test
        public void checkingRemove() {
                this.clear();
		Pizza pizza = new Pizza();
		pizza.setName("Margerita");
                pizza.setPrice(22);
                pizza.setDiameter(20);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
		pizza=null;
		pizza = new Pizza();
		pizza.setName("Carbonara");
                pizza.setPrice(222);
                pizza.setDiameter(20);
                pizza.setSold(false);
		pizzaManager.persist(pizza);
                
                pizza=null;
                pizza = pizzaManager.getpizzas("Margerita").get(0);
                pizzaManager.remove(pizza);
                
                List<Pizza> list = (List<Pizza>) pizzaManager.getAll();
                pizza = list.get(0);
                
                assertEquals(pizza.getName(), "Carbonara");
                assertEquals(pizza.getPrice(), 222.0, 0.01);
                assertEquals(pizza.getDiameter(), 20);
                assertEquals(pizza.getSold(), false);
        }
        
        
       

}
