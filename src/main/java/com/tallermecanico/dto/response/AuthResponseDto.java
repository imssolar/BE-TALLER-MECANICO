package com.tallermecanico.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallermecanico.enums.TokenType;

public class AuthResponseDto {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("access_token_expiry")
    private int accessTokenExpiry;

    @JsonProperty("token_type")
    private TokenType tokenType;

    @JsonProperty("user_name")
    private String userName;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String accessToken, int accessTokenExpiry, TokenType tokenType, String userName) {
        this.accessToken = accessToken;
        this.accessTokenExpiry = accessTokenExpiry;
        this.tokenType = tokenType;
        this.userName = userName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getAccessTokenExpiry() {
        return accessTokenExpiry;
    }

    public void setAccessTokenExpiry(int accessTokenExpiry) {
        this.accessTokenExpiry = accessTokenExpiry;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
