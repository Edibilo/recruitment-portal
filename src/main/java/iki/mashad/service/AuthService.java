package iki.mashad.service;

import iki.mashad.dto.UserDto;

public interface AuthService {
    String register(UserDto userDto);
}
