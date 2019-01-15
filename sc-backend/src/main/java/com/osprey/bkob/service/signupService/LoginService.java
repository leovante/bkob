package com.osprey.bkob.service.signupService;

import com.osprey.bkob.domain.forms.UserLogin;

public interface LoginService {

     String createToken(UserLogin userLogin);


}
