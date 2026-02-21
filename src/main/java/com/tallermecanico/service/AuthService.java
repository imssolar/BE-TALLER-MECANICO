package com.tallermecanico.service;

import com.tallermecanico.dto.request.SignUpRequestDto;
import com.tallermecanico.dto.response.AuthResponseDto;
import com.tallermecanico.entity.RefreshToken;
import com.tallermecanico.entity.User;
import com.tallermecanico.enums.TokenType;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.repository.RefreshTokenRepository;
import com.tallermecanico.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       RefreshTokenRepository refreshTokenRepository,
                       JwtTokenGenerator jwtTokenGenerator,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AuthResponseDto authenticate(Authentication authentication) {
        try {
            var user = userRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> {
                        log.error("[AuthService:authenticate] Usuario no encontrado: {}", authentication.getName());
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
                    });

            String accessToken = jwtTokenGenerator.generateAccessToken(authentication);
            String refreshToken = jwtTokenGenerator.generateRefreshToken(authentication);

            saveUserRefreshToken(user, refreshToken);

            log.info("[AuthService:authenticate] Tokens generados para usuario: {}", user.getUsername());

            AuthResponseDto response = new AuthResponseDto();
            response.setAccessToken(accessToken);
            response.setAccessTokenExpiry(15 * 60);
            response.setUserName(user.getUsername());
            response.setTokenType(TokenType.Bearer);
            return response;

        } catch (Exception e) {
            log.error("[AuthService:authenticate] Error al autenticar: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al autenticar");
        }
    }

    @Transactional
    public AuthResponseDto refreshToken(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(TokenType.Bearer.name())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de token inválido");
        }

        final String refreshToken = authHeader.substring(7);

        var refreshTokenEntity = refreshTokenRepository.findByRefreshToken(refreshToken)
                .filter(token -> !token.getRevoked())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Refresh token revocado o inválido"));

        User user = refreshTokenEntity.getUser();

        Authentication authentication = createAuthenticationObject(user);

        String newAccessToken = jwtTokenGenerator.generateAccessToken(authentication);

        log.info("[AuthService:refreshToken] Nuevo access token generado para: {}", user.getUsername());

        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(newAccessToken);
        response.setAccessTokenExpiry(15 * 60);
        response.setUserName(user.getUsername());
        response.setTokenType(TokenType.Bearer);
        return response;
    }

    @Transactional
    public AuthResponseDto registerUser(SignUpRequestDto signUpRequest) {
        log.info("[AuthService:registerUser] Registro iniciado para: {}", signUpRequest.getUsername());

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new DuplicateResourceException("User", "username", signUpRequest.getUsername());
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(signUpRequest.getRole());
        user.setEnabled(true);

        User savedUser = userRepository.save(user);

        Authentication authentication = createAuthenticationObject(savedUser);

        String accessToken = jwtTokenGenerator.generateAccessToken(authentication);
        String refreshToken = jwtTokenGenerator.generateRefreshToken(authentication);

        saveUserRefreshToken(savedUser, refreshToken);

        log.info("[AuthService:registerUser] Usuario registrado exitosamente: {}", savedUser.getUsername());

        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(accessToken);
        response.setAccessTokenExpiry(15 * 60);
        response.setUserName(savedUser.getUsername());
        response.setTokenType(TokenType.Bearer);
        return response;
    }

    private void saveUserRefreshToken(User user, String refreshToken) {
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setUser(user);
        refreshTokenEntity.setRefreshToken(refreshToken);
        refreshTokenEntity.setRevoked(false);
        refreshTokenRepository.save(refreshTokenEntity);
    }

    private static Authentication createAuthenticationObject(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String roles = user.getRole();

        String[] roleArray = roles.split(",");
        GrantedAuthority[] authorities = Arrays.stream(roleArray)
                .map(role -> (GrantedAuthority) role::trim)
                .toArray(GrantedAuthority[]::new);

        return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(authorities));
    }
}
