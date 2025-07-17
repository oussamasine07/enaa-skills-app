package org.enaaskillsapp.authservice.controller;


import org.enaaskillsapp.authservice.dto.validation.LoginValidationDTO;
import org.enaaskillsapp.authservice.model.Admin;
import org.enaaskillsapp.authservice.model.User;
import org.enaaskillsapp.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AuthController {

    private final AuthService authService;

    public AuthController (
            final AuthService authService
    ) {
        this.authService = authService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> login (@RequestBody LoginValidationDTO loginValidationDTO) {

        User user = new Admin();

        user.setEmail( loginValidationDTO.email() );
        user.setPassword( loginValidationDTO.password() );

        return authService.loginUser(user);
    }

}























