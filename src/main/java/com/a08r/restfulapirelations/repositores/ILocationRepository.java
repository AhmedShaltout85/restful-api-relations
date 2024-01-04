package com.a08r.restfulapirelations.repositores;

import com.a08r.restfulapirelations.modles.entities.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {
}
