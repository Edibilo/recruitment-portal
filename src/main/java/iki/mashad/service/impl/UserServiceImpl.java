package iki.mashad.service.impl;

import iki.mashad.dto.UserDto;
import iki.mashad.entity.User;
import iki.mashad.mapper.UserMapper;
import iki.mashad.repository.UserRepository;
import iki.mashad.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto profile() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User user=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        UserDto userDto=new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRoleName(user.getRole().getName());
        return userDto;
    }

    @Override
    public UserDto findLoggedInUserById() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User user=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Not Found !")
        );
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Not Found !")
        );
        userRepository.delete(user);
    }

}
