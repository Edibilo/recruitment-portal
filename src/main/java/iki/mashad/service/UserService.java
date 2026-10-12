package iki.mashad.service;

import iki.mashad.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto profile();
    UserDto findLoggedInUserById();
    List<UserDto> getAllUsers();
    UserDto findUserById(Long userId);
    void  deleteUser(Long userId);
}
