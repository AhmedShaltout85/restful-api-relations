package com.a08r.restfulapirelations.modles.mapper;


import com.a08r.restfulapirelations.modles.entities.dto.UserLocationDTO;
import com.a08r.restfulapirelations.modles.entities.users.User;

public interface IUserLocationMapper {
    User userLocationDtoToUser(UserLocationDTO userLocationDTO);
    UserLocationDTO userToUserLocationDTO(User user);
}
