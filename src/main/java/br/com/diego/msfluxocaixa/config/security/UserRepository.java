package br.com.diego.msfluxocaixa.config.security;

import br.com.diego.msfluxocaixa.config.security.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String>{
    Optional<UserEntity> findByEmail(String email);
}
