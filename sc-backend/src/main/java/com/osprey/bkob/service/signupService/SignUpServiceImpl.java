package com.osprey.bkob.service.signupService;

import com.google.common.collect.ImmutableSet;
import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.domain.enums.Role;
import com.osprey.bkob.domain.enums.State;
import com.osprey.bkob.domain.forms.UserRegistration;
import com.osprey.bkob.repository.UserRepository;
import com.osprey.bkob.service.MailService;
import com.osprey.bkob.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * Регистрация пользователя;
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final MailService mailService;


    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder, UserService userService, UserService userService1, MailService mailService) {
        this.repository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService1;
        this.mailService = mailService;
    }

    /**
     * Автоматическая генерация root пользователя;
     */
    @PostConstruct
    public void init() {
        String login = "admin@localhost";

        if (!repository.findByEmail(login).isPresent()) {
            repository.save(User.builder()
                    .firstName("firstName")
                    .password(passwordEncoder.encode("password"))
                    .email(login)
                    .roles(ImmutableSet.of(Role.ADMIN))
                    .state(State.ACTIVE)
                    .build());
        }
    }

    /**
     * Сохранение пользоватебя в хранилищи;
     */
    @Override
  public boolean signUp(UserRegistration userRegistration) {
        if ( repository.findByEmail(userRegistration.getEmail()).isPresent()) {
            return false;
        } else {



            String hashPassword = passwordEncoder.encode(userRegistration.getPassword()); //Шифруем пароль пользователя

            User user = User.builder()  //Конвертируем информацию с внешней формы UserRegistration в полноценного пользователя User;
                    .password(hashPassword)
                    .email(userRegistration.getEmail())
                    .roles(ImmutableSet.of(Role.GUEST))
                    .state(State.ACTIVE)
                    .activationCode(userRegistration.getActivationCode())
                    .userName(userRegistration.getUsername())
                    .country(userRegistration.getCountry())
                    .lang1(userRegistration.getLanguages().get(0))
                    .lang2(userRegistration.getLanguages().get(1))
                    .lang3(userRegistration.getLanguages().get(2))
                    .day(userRegistration.getDay())
                    .year(userRegistration.getYear())
                    .month(userRegistration.getMonth())
                    .activationCode(userService.generateCode())
                    .build();

            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to bkob. Please activate your account: http://localhost:8585/activate/%s",
                    user.getEmail(),
                    user.getActivationCode()
            );

            mailService.send(user.getEmail(), "Activation Code", message);
            repository.save(user);
            return true;
        }

    }

}
