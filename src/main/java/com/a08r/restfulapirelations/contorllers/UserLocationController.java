package com.a08r.restfulapirelations.contorllers;

import com.a08r.restfulapirelations.modles.entities.dto.UserLocationDTO;
import com.a08r.restfulapirelations.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user-loc")
public class UserLocationController {
    private final IUserService iUserService;

    @Autowired
    public UserLocationController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public ResponseEntity<List<UserLocationDTO>> getAll(){
        return this.iUserService.findAll();
    }

    @GetMapping(path ="/{userId}" )
    public ResponseEntity<UserLocationDTO> findUserById(@PathVariable Long userId){
        return this.iUserService.findById(userId);

    }
    @PostMapping
    public ResponseEntity<UserLocationDTO> createUser(@RequestBody UserLocationDTO addUserLocationDto){
        return this.iUserService.create(addUserLocationDto);
    }

    @PutMapping(path = "/{courseId}")
    public ResponseEntity<UserLocationDTO> updateUser(
            @PathVariable Long userId,
            @RequestBody UserLocationDTO addUserLocationDto){
        return this.iUserService.update(userId, addUserLocationDto);
    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long userId){
        return this.iUserService.remove(userId);
    }

}
