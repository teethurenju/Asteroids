package com.asteroids.model;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class NearEarthObjects{
	
	HashMap<String,ArrayList<AsteroidsModel>> near_earth_objects;
}
