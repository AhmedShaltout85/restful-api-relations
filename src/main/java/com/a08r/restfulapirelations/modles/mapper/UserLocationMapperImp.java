package com.a08r.restfulapirelations.modles.mapper;


import com.a08r.restfulapirelations.modles.entities.dto.UserLocationDTO;
import com.a08r.restfulapirelations.modles.entities.location.Location;
import com.a08r.restfulapirelations.modles.entities.users.User;

public class UserLocationMapperImp implements IUserLocationMapper {
    @Override
    public User userLocationDtoToUser(UserLocationDTO userLocationDTO) {
        User user = new User();

        user.setUsername(userLocationDTO.getUsername());
        user.setEmail(userLocationDTO.getEmail());
        user.setLocation(new Location());
        return null;
    }

    @Override
    public UserLocationDTO userToUserLocationDTO(User user) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUsername(user.getUsername());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        return userLocationDTO;
    }


}
