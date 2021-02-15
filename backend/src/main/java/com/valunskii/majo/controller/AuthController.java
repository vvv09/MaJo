package com.valunskii.majo.controller;

import com.valunskii.majo.domain.Role;
import com.valunskii.majo.domain.User;
import com.valunskii.majo.payload.request.LoginRequest;
import com.valunskii.majo.payload.request.RegistrationRequest;
import com.valunskii.majo.payload.response.JwtResponse;
import com.valunskii.majo.payload.response.MessageResponse;
import com.valunskii.majo.repo.UserRepo;
import com.valunskii.majo.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    AuthenticationManager authenticationManager;
    UserRepo userRepo;
    PasswordEncoder encoder;
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User principal = (User) authentication.getPrincipal();
        List<String> roles = principal.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                principal.getId(),
                principal.getUsername(),
                principal.getFullName(),
                principal.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        if (userRepo.existsByUsername(registrationRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepo.existsByEmail(registrationRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(registrationRequest.getFullName(), registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                encoder.encode(registrationRequest.getPassword()));

        Set<String> strRoles = registrationRequest.getRole();
        Set<Role> roles = new HashSet<>();

        user.setRegistrationDate(LocalDateTime.now());
        user.setActive(true);
        user.setRoles(Set.of(Role.ROLE_USER));
        userRepo.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
