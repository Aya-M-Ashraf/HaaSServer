package com.haas.server.utils;

import commons.dto.UserDTO;
import com.haas.server.entity.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aya M. Ashraf
 */
@Component
public class EntityMapper {

    public EntityMapper() {

    }

    public User mapUserDtoToUser(UserDTO userDto) {
        User user = new User(userDto.getUserId(), userDto.getEmail(), userDto.getFirstName(), userDto.getLastName(), userDto.getPhone(), userDto.getPassword(), userDto.getGoldenCoins(), userDto.getSilverCoins(), userDto.getGender(), userDto.getCountry());
        return user;
    }

    public UserDTO mapUserToUserDto(User user) {
        UserDTO userDto = new UserDTO(user.getUserId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getPassword(), user.getGoldenCoins(), user.getSilverCoins(), user.getGender(), user.getCountry());
        return userDto;
    }

}
