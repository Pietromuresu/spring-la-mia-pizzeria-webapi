package org.java.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.POJO.Offer;
import org.java.POJO.Pizza;
import org.java.api.DTO.PizzaDTO;
import org.java.serv.OfferService;
import org.java.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0")
public class PizzaRestController {

	
	@Autowired
	private PizzaService pizzaServ;
	
	@Autowired
	private OfferService offerServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<Pizza>> getAll() {
		
		List<Pizza> pizzas = pizzaServ.findAll();
		
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	@GetMapping("/all/{name}")
	public ResponseEntity<List<Pizza>> getByName(@PathVariable("name") String name) {
		
		List<Pizza> pizzas = pizzaServ.findByName(name);
		
		
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		
		Optional<Pizza> pizza = pizzaServ.findById(Long.valueOf(id));
		
		if(pizza.isEmpty()) {
			String response = "Nessuna pizza trovata con questo id";
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		

		return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Pizza> addNew(@RequestBody PizzaDTO  pizzaDto) {
		
		Pizza pizza = new Pizza(pizzaDto);
		
		pizza = pizzaServ.save(pizza);
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> addNew(
			@PathVariable int id,
			@RequestBody PizzaDTO  pizzaDto) {
		
		Optional<Pizza> pizza = pizzaServ.findById(Long.valueOf(id));
		
		if(pizza.isEmpty()) {
			String response = "Nessuna pizza trovata con questo id";
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		Pizza pizzaToUpdate = pizza.get();
		pizzaToUpdate.updatePizzaFromDto(pizzaDto);
		
		try {
			
			pizzaServ.save(pizzaToUpdate);
		}catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(pizzaToUpdate, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		Optional<Pizza> pizza = pizzaServ.findById(Long.valueOf(id));
		
		if(pizza.isEmpty()) {
			String response = "Nessuna pizza trovata con questo id";
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		Pizza pizzaToDelete = pizza.get();
		
		if(pizzaToDelete.getOffers().size() > 0) {
			for(Offer offer : pizzaToDelete.getOffers() ) {
				
				offerServ.deleteById(offer.getId());
			}
		}
		
		pizzaServ.deleteById(Long.valueOf(id));
		
		return new ResponseEntity<>("Deleted succesfully", HttpStatus.OK);
	}
	
}
