package com.asteroids.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asteroids.service.AsteroidsService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/v1/spondAsteroidsApi")
public class AsteroidsController {

	private final AsteroidsService asteroidsService;
	
	public AsteroidsController(AsteroidsService asteroidsService) {		
		this.asteroidsService = asteroidsService;
	}
	

	@GetMapping(value = "/near-asteroids", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Object> getAsteroids(@RequestParam String startDate,@RequestParam String endDate) {
		
		Object response = asteroidsService.getClosestAsteroids(startDate, endDate);
		return ResponseEntity.ok().body(response);
    }
	
	@GetMapping(value = "/large-asteroid", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getLargeAsteroidsDetails(@RequestParam String year) {
		
		Object response = asteroidsService.getLargeAsteroidsDetails(year);
        return ResponseEntity.ok().body(response);
    }
}
