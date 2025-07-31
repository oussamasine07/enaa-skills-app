package org.enaaskillsapp.authservice.service;


import org.enaaskillsapp.authservice.dto.validation.RegisterUserValidationDTO;
import org.enaaskillsapp.authservice.exception.PasswordIncorrectException;
import org.enaaskillsapp.authservice.dto.mapping.AuthUserDTO;
import org.enaaskillsapp.authservice.mapping.AdminMapper;
import org.enaaskillsapp.authservice.mapping.CoachMapper;
import org.enaaskillsapp.authservice.mapping.LearnerMapper;
import org.enaaskillsapp.authservice.model.Admin;
import org.enaaskillsapp.authservice.model.Coach;
import org.enaaskillsapp.authservice.model.Learner;
import org.enaaskillsapp.authservice.model.User;
import org.enaaskillsapp.authservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    public final JwtService jwtService;
    public final AuthenticationManager authenticationManager;
    public final UserRepository userRepository;

    public final AdminMapper adminMapper;
    public final CoachMapper coachMapper;
    public final LearnerMapper learnerMapper;

    public AuthService (
            final JwtService jwtService,
            final AuthenticationManager authenticationManager,
            final UserRepository userRepository,
            final AdminMapper adminMapper,
            final CoachMapper coachMapper,
            final LearnerMapper learnerMapper
    ){
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;

        this.adminMapper = adminMapper;
        this.coachMapper = coachMapper;
        this.learnerMapper = learnerMapper;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<?> loginUser (User user) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                     user.getEmail(),
                                    user.getPassword()
                            )
                    );

            if (authentication.isAuthenticated()){
                AuthUserDTO authUser = this.getAuthenticatedUser(user.getEmail());
                String token = jwtService.generateJwtToken(authUser);

                Map<String, String> responseSuccess = new HashMap<>();
                responseSuccess.put("token", token);

                return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
            }

            throw  new PasswordIncorrectException("Invalid credentials");
        }
        catch (AuthenticationException e ) {
            throw  new PasswordIncorrectException("Invalid credentials");
        }
    }

    public AuthUserDTO getAuthenticatedUser ( String email ) {
        User authenticatedUser = userRepository.findUserByEmail( email );
        AuthUserDTO authUserDTO = null;
        switch (authenticatedUser.getClass().getSimpleName()) {
            case "Admin":
                authUserDTO = adminMapper.toDTO((Admin) authenticatedUser);
                break;
            case "Learner":
                authUserDTO = learnerMapper.toDTO((Learner) authenticatedUser);
                break;
            case "Coach":
                authUserDTO = coachMapper.toDTO((Coach) authenticatedUser);
                break;
        }
        return authUserDTO;
    }

    public ResponseEntity<?> registerUser (RegisterUserValidationDTO registerUserValidationDTO) {
        User user = null;

        switch (registerUserValidationDTO.role()){
            case "learner":
                user = new Learner();
                break;
            case "coach":
                user = new Coach();
                break;
        }

        user.setFirstName( registerUserValidationDTO.firstName() );
        user.setLastName( registerUserValidationDTO.lastName() );
        user.setEmail( registerUserValidationDTO.email() );
        user.setPassword( encoder.encode( registerUserValidationDTO.password() ) );

        User savedUser = userRepository.save( user );

        return new ResponseEntity<>( savedUser, HttpStatus.OK );
    }

}














