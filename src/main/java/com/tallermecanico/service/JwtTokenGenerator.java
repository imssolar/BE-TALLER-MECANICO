package com.tallermecanico.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.tallermecanico.config.RoleConfig;

@Service
public class JwtTokenGenerator {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenGenerator.class);

    private final JwtEncoder jwtEncoder;
    private final RoleConfig roleConfig;
    private final long accessTokenExpiryMinutes;

    public JwtTokenGenerator(JwtEncoder jwtEncoder, RoleConfig roleConfig, @Value("${jwt.access-token-expiry-minutes}") long accessTokenExpiryMinutes) {
        this.jwtEncoder = jwtEncoder;
        this.roleConfig = roleConfig;
        this.accessTokenExpiryMinutes = accessTokenExpiryMinutes;
    }

    public String generateAccessToken(Authentication authentication) {
        log.info("[JwtTokenGenerator:generateAccessToken] Token creation started for: {}", authentication.getName());

        String roles = getRolesOfUser(authentication);
        String permissions = getPermissionsFromRoles(roles);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("taller-mecanico")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(accessTokenExpiryMinutes, ChronoUnit.MINUTES))
                .subject(authentication.getName())
                .claim("scope", permissions)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateRefreshToken(Authentication authentication) {
        log.info("[JwtTokenGenerator:generateRefreshToken] Token creation started for: {}", authentication.getName());

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("taller-mecanico")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
                .subject(authentication.getName())
                .claim("scope", "REFRESH_TOKEN")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private static String getRolesOfUser(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }

    private String getPermissionsFromRoles(String roles) {
        Set<String> permissions = new HashSet<>();

        List<RoleConfig.Role> roleList = roleConfig.getList();

        roleList.forEach(role -> {
            if (roles.contains(role.getName())) {
                permissions.addAll(role.getScopes());
            }
        });

        return String.join(" ", permissions);
    }
}
