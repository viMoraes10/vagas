package com.example.demo.controller;

import com.example.demo.model.user.AuthenticationDTO;
import com.example.demo.model.user.RegisterDTO;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login (@RequestParam @Valid AuthenticationDTO data ){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO registerDTO ){
        //if this.userRepository.findByUsername(registerDTO.username() )
         // VOCÊ PAROU AQUI E ESTÁ NA PARTE 44:00
        return ResponseEntity.ok().build();
    }
}
