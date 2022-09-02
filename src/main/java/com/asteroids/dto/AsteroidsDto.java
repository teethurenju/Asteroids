package com.asteroids.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
public class AsteroidsDto implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -324040039895833874L;
	
	private Long id;
    private String name;    
    private String date;
    private String asteroids_id;
    private double estimated_diameter;
    
    
}
