package com.a08r.restfulapirelations.services;

import com.a08r.restfulapirelations.errors.RecordNotFoundException;
import com.a08r.restfulapirelations.modles.entities.dto.UserLocationDTO;
import com.a08r.restfulapirelations.modles.entities.users.User;
import com.a08r.restfulapirelations.modles.mapper.IUserLocationMapper;
import com.a08r.restfulapirelations.modles.mapper.UserLocationMapperImp;
import com.a08r.restfulapirelations.repositores.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    private final IUserRepository iUserRepository;
    private final IUserLocationMapper iUserLocationMapper = new UserLocationMapperImp();

    @Autowired
    public UserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ResponseEntity<List<UserLocationDTO>> findAll() {
        List<User> userList = iUserRepository.findAll();
        List<UserLocationDTO> userLocationDTO = userList
                .stream()
                .map(iUserLocationMapper::userToUserLocationDTO)
                .toList();
        return new ResponseEntity<>(userLocationDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserLocationDTO> findById(Long id) {
        Optional<User> user = iUserRepository.findById(id);
        if(user.isEmpty()){
            throw new RecordNotFoundException("the item with id: "+id +" not found!...");

        }
        UserLocationDTO userLocationDTO = iUserLocationMapper.userToUserLocationDTO(user.get());
        return new ResponseEntity<>(userLocationDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserLocationDTO> create(UserLocationDTO addUserLocationDTO) {
        final User user = iUserLocationMapper.userLocationDtoToUser(addUserLocationDTO);
        final User createdUser= this.iUserRepository.save(user);
        UserLocationDTO userLocationDTO = iUserLocationMapper.userToUserLocationDTO(createdUser);
        return new ResponseEntity<>(userLocationDTO,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserLocationDTO> update(Long id, UserLocationDTO userLocationDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        boolean exists = iUserRepository.existsById(id);
        if(!exists){
            throw new RecordNotFoundException("the item with id: "+id +" not found!...");

        }
         this.iUserRepository.deleteById(id);
        return new ResponseEntity<>("the item has been deleted successfully!",HttpStatus.NO_CONTENT);
    }
}
