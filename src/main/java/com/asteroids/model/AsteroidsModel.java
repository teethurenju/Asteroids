package com.asteroids.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.asteroids.config.ItemDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@JsonDeserialize(using = ItemDeserializer.class)
public class AsteroidsModel{
	private Links links;
    private int element_count;
    private LinkedHashMap<String, ArrayList<Astroid>> near_earth_objects;
    
    public AsteroidsModel(Links links, int element_count, LinkedHashMap<String, ArrayList<Astroid>> near_earth_objects) {
    	this.links = links;
        this.element_count = element_count;
        this.near_earth_objects = near_earth_objects;
    	
    }
    
    public AsteroidsModel() {
    	
    }
}
