package com.asteroids.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asteroids.domain.Asteroids;

@Repository
public interface AsteroidsRepository extends JpaRepository<Asteroids, Long>{

	
	@Query(value="select * from asteroids_table tbl where tbl.date between :startDate and :endDate order by tbl.asteroids_id desc limit 10", nativeQuery=true)
	Object[] getClosestAsteroids(@Param("startDate")String startDate,@Param("endDate")String endDate);
	
	@Query(value="select max(tbl.estimated_diameter),tbl.name,tbl.asteroids_id,tbl.date from asteroids_table tbl where year(tbl.date)=:year", nativeQuery=true)
	List<Object> getLargeAsteroidsDetails(@Param("year")String year);
	
}
