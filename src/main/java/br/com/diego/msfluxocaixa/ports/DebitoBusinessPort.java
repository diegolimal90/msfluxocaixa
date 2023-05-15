package br.com.diego.msfluxocaixa.ports;

import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import org.apache.commons.lang3.NotImplementedException;

public interface DebitoBusinessPort {

    default Lancamento cadastrarDebito(Lancamento lancamento) {
        throw new NotImplementedException("METODO NÃO IMPLEMENTADO.");
    }
}
