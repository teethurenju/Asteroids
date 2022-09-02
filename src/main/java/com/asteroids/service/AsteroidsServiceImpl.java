package com.asteroids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.asteroids.domain.Asteroids;
import com.asteroids.exception.DateValidation;
import com.asteroids.model.AsteroidsModel;
import com.asteroids.repository.AsteroidsRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.util.ObjectUtils;


@Slf4j
@Service
public class AsteroidsServiceImpl implements AsteroidsService{

	private final AsteroidsRepository asteroidsRepository;

	public AsteroidsServiceImpl(AsteroidsRepository asteroidsRepository) {
		this.asteroidsRepository = asteroidsRepository;

	}
	
	@Override
	public Object getClosestAsteroids(String startDate, String endDate) {
		
		String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";		
		
		if(!startDate.matches(datePattern) || !endDate.matches(datePattern)) {
			try {
				throw new DateValidation("Invalid Date Format");
		}catch(DateValidation e) {
			return e.getMessage();
		}
		}
		Object[] o = asteroidsRepository.getClosestAsteroids(startDate, endDate);
		
		if(ObjectUtils.isEmpty(o)) {
			
			getAsteroidsDetails(startDate,endDate);
			o = asteroidsRepository.getClosestAsteroids(startDate, endDate);
			return ResponseEntity.ok().body(o);
		}

		
		return o;

	}



	@Override
	public Object getLargeAsteroidsDetails(String year) {
		List<Object> o = asteroidsRepository.getLargeAsteroidsDetails(year);
		return o;
		
	}
	
	
	public Object getAsteroidsDetails(String startDate, String endDate){		
		
		String uri = "https://api.nasa.gov/neo/rest/v1/feed?start_date="+startDate+"&end_date="+endDate+"&api_key=IM37ULOareWRgZQLNS98x97CVkQjWumCB2gld4lM";
		
		RestTemplate restTemplate = new RestTemplate();
		UriComponents accountUri = UriComponentsBuilder.fromHttpUrl(uri).build();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<AsteroidsModel> asteroidApiResponseResponseEntity = restTemplate.exchange(accountUri.toString(), HttpMethod.GET, entity,
        		AsteroidsModel.class);
        
        
        asteroidApiResponseResponseEntity.getBody().getNear_earth_objects().values().forEach(q ->{
        	q.stream().forEach(w->{
        		Asteroids asteroids = new Asteroids();
            	asteroids.setName(w.name);
            	asteroids.setAsteroids_id(w.neo_reference_id);
            	asteroids.setEstimated_diameter(w.estimated_diameter.meters.estimated_diameter_max);
            	w.close_approach_data.stream().forEach(r->{
            		asteroids.setDate(r.close_approach_date);
            	});
    		    asteroidsRepository.save(asteroids);
        		
        	});
        });

			
		return asteroidApiResponseResponseEntity.getBody();  
		
	}

	

	


	
	
	

}
