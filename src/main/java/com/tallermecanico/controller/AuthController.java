package com.tallermecanico.controller;

import com.tallermecanico.dto.request.SignUpRequestDto;
import com.tallermecanico.dto.response.AuthResponseDto;
import com.tallermecanico.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponseDto> signIn(Authentication authentication) {
        AuthResponseDto response = authService.authenticate(authentication);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDto> signUp(@Valid @RequestBody SignUpRequestDto signUpRequest) {
        AuthResponseDto response = authService.registerUser(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasAuthority('SCOPE_REFRESH_TOKEN')")
    @PostMapping("/refresh-token")
    public ResponseEntity<AuthResponseDto> refreshToken(HttpServletRequest request) {
        AuthResponseDto response = authService.refreshToken(request);
        return ResponseEntity.ok(response);
    }
}
