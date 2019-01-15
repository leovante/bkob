package com.osprey.bkob.config.token;

import com.osprey.bkob.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Получение информации о пользователе по логину и заполняем UserDetails;
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;

    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Поиск пользователя в хранилище и загрузка в UserDetails;
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(usersRepository.findByEmail(username)
                .orElseThrow(IllegalArgumentException::new));
    }

}
