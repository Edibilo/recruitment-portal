package iki.mashad.security;

import iki.mashad.entity.User;
import iki.mashad.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class CustomerUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomerUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByEmail(username).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        Set<GrantedAuthority> authorities= Collections.singleton(
                new SimpleGrantedAuthority(user.getRole().getName())
        );
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }
}
