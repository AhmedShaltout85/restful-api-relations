package com.a08r.restfulapirelations.services;

import com.a08r.restfulapirelations.modles.entities.dto.UserLocationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<List<UserLocationDTO>> findAll();
    ResponseEntity<UserLocationDTO> findById(Long id);
    ResponseEntity<UserLocationDTO> create(UserLocationDTO userLocationDTO);
    ResponseEntity<UserLocationDTO> update(Long id, UserLocationDTO userLocationDTO);
    ResponseEntity<String> remove(Long id);
}
