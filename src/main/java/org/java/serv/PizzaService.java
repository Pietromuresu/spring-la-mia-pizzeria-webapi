package org.java.serv;

import java.util.List;
import java.util.Optional;

import org.java.POJO.Pizza;
import org.java.interfaces.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepo pizzaRepo;
	
	public Pizza save(Pizza pizza) {
		
		return pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findAll() {
		
		return pizzaRepo.findAll();
	}
	
	public List<Pizza> findByName(String name) {
		
		return pizzaRepo.findByNameContaining(name);
	}
	
	public Optional<Pizza> findById(Long id) {
		
		return pizzaRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		pizzaRepo.deleteById(id);
	}
	
	public void updatePizza(Pizza pizza) {
		
		Long id = pizza.getId();
		Pizza pizzaToUpdate = pizzaRepo.findById(id).get();
		
//		pizzaToUpdate.setName(pizza.getName());
//		pizzaToUpdate.setDescription(pizza.getDescription());
//		pizzaToUpdate.setFotoUrl(pizza.getFotoUrl());
//		pizzaToUpdate.setPrice(pizza.getPrice());
	
		
		pizzaRepo.save(pizzaToUpdate);
	}
}