package br.com.diego.msfluxocaixa.adapters.out.providers;

import br.com.diego.msfluxocaixa.adapters.out.mapper.LancamentoEntityMapper;
import br.com.diego.msfluxocaixa.adapters.out.repository.LancamentoRepository;
import br.com.diego.msfluxocaixa.adapters.out.repository.entities.LancamentoEntity;
import br.com.diego.msfluxocaixa.config.exception.DataBaseException;
import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.ports.LancamentoProviderPort;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LancamentoProvider implements LancamentoProviderPort {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public Lancamento cadastrarLancamento(Lancamento lancamento) {
        try {
            LancamentoEntity entity = lancamentoRepository.insert(LancamentoEntityMapper.from(lancamento));
            return LancamentoEntityMapper.to(entity);
        }catch (MongoException ex){
            throw new DataBaseException("Falha na persistência dos dados!", ex.getCause());
        }
    }
}
