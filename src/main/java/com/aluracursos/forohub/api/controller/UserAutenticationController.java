package com.aluracursos.forohub.api.controller;

import com.aluracursos.forohub.api.domain.user.LoginRequestDTO;
import com.aluracursos.forohub.api.domain.user.User;
import com.aluracursos.forohub.api.infra.security.DTOResponseJWToken;
import com.aluracursos.forohub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserAutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity userAuthentication(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password());
        var userAuth = authenticationManager.authenticate( authToken );
        var JWToken = tokenService.generateToken((User) userAuth.getPrincipal());
        return ResponseEntity.ok( new DTOResponseJWToken(JWToken));
    }


}