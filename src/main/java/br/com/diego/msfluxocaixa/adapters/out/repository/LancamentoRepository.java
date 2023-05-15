package br.com.diego.msfluxocaixa.adapters.out.repository;

import br.com.diego.msfluxocaixa.adapters.out.repository.entities.LancamentoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LancamentoRepository extends MongoRepository<LancamentoEntity, String> {
}
