package br.com.diego.msfluxocaixa.core.business;

import br.com.diego.msfluxocaixa.config.exception.BadRequestException;
import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.core.domain.enums.TipoLancamentoEnum;
import br.com.diego.msfluxocaixa.ports.CreditoBusinessPort;
import br.com.diego.msfluxocaixa.ports.LancamentoProviderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarCreditoBusiness implements CreditoBusinessPort {

    @Autowired
    private LancamentoProviderPort lancamentoProviderPort;

    @Override
    public Lancamento cadastrarCredito(Lancamento domain) {
        if(!TipoLancamentoEnum.CREDITO.getValue().equals(domain.getTipoLancamento().getValue())){
            throw new BadRequestException("Campo tipoLancamento inválido para essa operação.");
        }
        return lancamentoProviderPort.cadastrarLancamento(domain);
    }
}
