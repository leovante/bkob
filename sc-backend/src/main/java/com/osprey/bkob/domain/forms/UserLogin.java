package com.osprey.bkob.domain.forms;

import com.osprey.bkob.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Получение данные(сredentials) о пользователи с внешней формы;
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin extends User {
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Email cannot be empty")
    private String password;
    @NotBlank(message = "Email cannot be empty")
    private String rememberMe;

}
