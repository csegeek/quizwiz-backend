package com.quizwiz.quizwizbackend.controller;

import com.quizwiz.quizwizbackend.entities.User;
import com.quizwiz.quizwizbackend.payload.JwtRequest;
import com.quizwiz.quizwizbackend.payload.JwtResponse;
import com.quizwiz.quizwizbackend.security.JwtTokenUtil;
import com.quizwiz.quizwizbackend.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
//@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest loginRequest){
        this.doAuthenticate(loginRequest.getUserName(),loginRequest.getPassword());
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(loginRequest.getUserName());
        String token = this.jwtTokenUtil.generateToken(userDetails);
        JwtResponse response =new JwtResponse();
        response.setUserName(userDetails.getUsername());
        response.setToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);
        }
        catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
      return (User)userDetailsService.loadUserByUsername(principal.getName());
    }



}
