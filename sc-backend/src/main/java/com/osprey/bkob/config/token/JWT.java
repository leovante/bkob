package com.osprey.bkob.config.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Object to return as body in JWT Authentication.
 */
@AllArgsConstructor
@Builder
public class JWT implements AuthToken {

    private final String accessToken;

    private final int expiresIn;

    @Override
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    @JsonProperty("expires_in")
    public int getExpiresIn() {
        return expiresIn;
    }
}

