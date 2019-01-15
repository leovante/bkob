package com.osprey.bkob.domain.forms;

import com.osprey.bkob.domain.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Setter
@Getter
public class UserRegistration extends User  {

      @Email(message = "Email is not correct")
      @NotBlank(message = "Email cannot be empty")
      private String email;
      @NotBlank(message = "Password cannot be empty")
      private String password;
      @NotBlank(message = "UserName cannot be empty")
      private String username;
      @NotBlank(message = "Password cannot be empty")
      private Short year;
      @NotBlank(message = "Password cannot be empty")
      private String country;
      @NotBlank(message = "Password cannot be empty")
      private ArrayList<String> languages;
      @NotBlank(message = "Password cannot be empty")
      private Short day;
      @NotBlank(message = "Password cannot be empty")
      private String month;


   /*@NotBlank(message = "Confirm password cannot be empty")
      private String confirmPassword;*/
      private String activationCode;


}
