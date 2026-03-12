package com.tallermecanico.service;

import com.tallermecanico.repository.RefreshTokenRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LogoutHandlerService implements LogoutHandler {

    private static final Logger log = LoggerFactory.getLogger(LogoutHandlerService.class);

    private final RefreshTokenRepository refreshTokenRepository;

    public LogoutHandlerService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return;
        }

        String refreshToken = Arrays.stream(cookies)
                .filter(c -> "refresh_token".equals(c.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (refreshToken == null) {
            return;
        }

        refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(token -> {
                    token.setRevoked(true);
                    refreshTokenRepository.save(token);
                    log.info("[LogoutHandlerService:logout] Refresh token revocado exitosamente");
                    return token;
                }).orElse(null);

        Cookie expiredCookie = new Cookie("refresh_token", null);
        expiredCookie.setHttpOnly(true);
        expiredCookie.setPath("/api/auth/refresh-token");
        expiredCookie.setMaxAge(0);
        response.addCookie(expiredCookie);
    }
}
