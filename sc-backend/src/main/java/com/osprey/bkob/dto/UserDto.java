package com.osprey.bkob.dto;

import com.osprey.bkob.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;



@Getter
@AllArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String password;
    private State state;



}
