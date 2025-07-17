package org.enaaskillsapp.authservice.service;

import org.enaaskillsapp.authservice.model.User;
import org.enaaskillsapp.authservice.model.UserPrincipal;
import org.enaaskillsapp.authservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(
            final UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("this user is not found");
        }

        return new UserPrincipal(user);
    }
}
