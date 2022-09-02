package com.asteroids.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="asteroids_table")
public class Asteroids {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "asteroids_id")
    private String asteroids_id;
    @Column(name = "date")
    private String date;
    @Column(name = "estimated_diameter")
    private double estimated_diameter;

}
