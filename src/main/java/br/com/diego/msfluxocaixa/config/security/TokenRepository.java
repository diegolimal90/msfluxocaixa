package br.com.diego.msfluxocaixa.config.security;

import br.com.diego.msfluxocaixa.config.security.entity.TokenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<TokenEntity, String> {
    Optional<TokenEntity> findByToken(String token);
    List<TokenEntity> findByUserId(String userId);
}
