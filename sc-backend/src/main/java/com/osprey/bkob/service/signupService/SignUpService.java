package com.osprey.bkob.service.signupService;


import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.domain.forms.UserRegistration;

public interface SignUpService {

    boolean signUp (UserRegistration userRegistration);


}
