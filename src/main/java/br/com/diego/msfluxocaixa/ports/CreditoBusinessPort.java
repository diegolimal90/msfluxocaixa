package br.com.diego.msfluxocaixa.ports;

import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import org.apache.commons.lang3.NotImplementedException;

public interface CreditoBusinessPort {

    default Lancamento cadastrarCredito(Lancamento domain) {
        throw new NotImplementedException("METODO NÃO IMPLEMENTADO.");
    }
}
