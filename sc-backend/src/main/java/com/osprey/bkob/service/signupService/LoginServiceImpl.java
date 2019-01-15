package com.osprey.bkob.service.signupService;

import com.osprey.bkob.config.token.TokenProvider;
import com.osprey.bkob.domain.forms.UserLogin;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Процедура Authentication;
 */
@Service
public class LoginServiceImpl  implements LoginService {

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public String createToken(UserLogin userLogin) {
        final UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword());
        try{
            final Authentication authentication = this.authenticationManager.authenticate(authToken);   // получаем пользователя (проверка логина и пароля)- магия;
            SecurityContextHolder.getContext().setAuthentication(authentication);   // помещаем в контекст Spring Security;

            final boolean rememberMe = userLogin.getRememberMe() == null ? false : Boolean.parseBoolean(userLogin.getRememberMe());

            return this.tokenProvider.createToken(authentication, rememberMe, false);
        }catch (Exception ex){
            return "null";
        }



    }
}
