package com.osprey.bkob.config.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface AuthToken {

    String getAccessToken();

    @JsonProperty("token_type")
    default String getTokenType() {
        return "bearer";
    }

    int getExpiresIn();

}
