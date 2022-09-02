package com.asteroids.service;


public interface AsteroidsService {
	
	Object getClosestAsteroids(String startDate,String endDate);
	Object getLargeAsteroidsDetails(String year);

}
