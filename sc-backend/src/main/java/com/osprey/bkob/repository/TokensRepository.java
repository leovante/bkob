package com.osprey.bkob.repository;

import com.osprey.bkob.domain.entities.Token;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokensRepository extends BaseRepository<Token, Long> {

    Optional<Token> findOneByTokenSession(String token);
}
