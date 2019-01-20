package com.osprey.bkob.service.signupService;

import com.osprey.bkob.config.token.AuthToken;
import com.osprey.bkob.domain.forms.UserLogin;

public interface LoginService {

    AuthToken createToken(UserLogin userLogin);


}
