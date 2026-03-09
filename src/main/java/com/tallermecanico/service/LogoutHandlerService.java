package com.tallermecanico.service;

import com.tallermecanico.enums.TokenType;
import com.tallermecanico.repository.RefreshTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutHandlerService implements LogoutHandler {

    private static final Logger log = LoggerFactory.getLogger(LogoutHandlerService.class);

    private final RefreshTokenRepository refreshTokenRepository;

    public LogoutHandlerService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(TokenType.Bearer.name())) {
            return;
        }

        final String refreshToken = authHeader.substring(7);

        refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(token -> {
                    token.setRevoked(true);
                    refreshTokenRepository.save(token);
                    log.info("[LogoutHandlerService:logout] Refresh token revocado exitosamente");
                    return token;
                }).orElse(null);
    }
}
