package com.studentportal.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            System.out.println("Received authentication request with username: " + authenticationRequest.getUsername());

            // Attempt authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

            // This line will be executed only if authentication is successful
            System.out.println("-------------------");

            // Load user details
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            System.out.println("UserDetails: " + userDetails);

            // Generate JWT token
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println("JWT: " + jwt);

            // Return response
            return ResponseEntity.ok(new JwtResponse(jwt));

        } catch (BadCredentialsException e) {
            System.out.println("Exception: Incorrect username or password");
            throw new Exception("Incorrect username or password", e);
        } catch (Exception e) {
            // Log other exceptions
            System.out.println("Exception: " + e.getMessage());
            throw e;
        }
    }

}

