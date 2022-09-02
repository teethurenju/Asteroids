package com.asteroids.model;

import java.util.ArrayList;


public class Astroid {

	public Links links;
    public String id;
    public String neo_reference_id;
    public String name;
    public String nasa_jpl_url;
    public double absolute_magnitude_h;
    public EstimatedDiameter estimated_diameter;
    public boolean is_potentially_hazardous_asteroid;
    public ArrayList<CloseApproachDatum> close_approach_data;
    public boolean is_sentry_object;
}
