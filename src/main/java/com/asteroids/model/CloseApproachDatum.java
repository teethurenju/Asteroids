package com.asteroids.model;

import lombok.Data;

@Data
public class CloseApproachDatum{
    public String close_approach_date;
    public String close_approach_date_full;
    public Object epoch_date_close_approach;
    public RelativeVelocity relative_velocity;
    public MissDistance miss_distance;
    public String orbiting_body;
}
