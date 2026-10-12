package iki.mashad.mapper;

import iki.mashad.dto.UserDto;
import iki.mashad.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        return user;
    }

    public static UserDto mapToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRoleId(user.getRole().getId());
        userDto.setRoleName(user.getRole().getName());
        return userDto;
    }
}
