package org.java.api.controller;

import java.util.List;

import org.java.POJO.Pizza;
import org.java.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0")
public class PizzaRestController {

	
	@Autowired
	private PizzaService pizzaServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<Pizza>> getAll() {
		
		List<Pizza> pizzas = pizzaServ.findAll();
		
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
}
