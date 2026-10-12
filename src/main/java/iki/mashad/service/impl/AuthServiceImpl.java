package iki.mashad.service.impl;

import iki.mashad.dto.UserDto;
import iki.mashad.entity.Role;
import iki.mashad.entity.User;
import iki.mashad.repository.RoleRepository;
import iki.mashad.repository.UserRepository;
import iki.mashad.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public String register(UserDto userDto) {

        Role role;
        User user;
        if(userDto.getId()==null){
            if(userRepository.existsByEmail(userDto.getEmail())){
                throw new RuntimeException("Email Already Exist !");
            }
            user=new User();
            role=roleRepository.findRoleByName("ROLE_APPLICANT");
        }else{
            user=userRepository.findById(userDto.getId()).orElseThrow(
                    () -> new RuntimeException("User Not Found !")
            );
            role=roleRepository.findById(userDto.getRoleId()).orElseThrow(
                    () -> new RuntimeException("Role Not Found !")
            );
        }
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(role);
        userRepository.save(user);
        return "Register Successfully !";
    }
}
