package br.com.diego.msfluxocaixa.business;

import br.com.diego.msfluxocaixa.core.business.CadastrarCreditoBusiness;
import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.core.domain.enums.TipoLancamentoEnum;
import br.com.diego.msfluxocaixa.ports.LancamentoProviderPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CadastrarCreditoBusinessTest {

    @Mock
    private LancamentoProviderPort lancamentoProviderPort;
    @InjectMocks
    private CadastrarCreditoBusiness cadastrarCreditoBusiness;

    @Test
    void cadastrarCreditoSuccess(){
        Lancamento lancamento = Lancamento.builder()
                .idLancamento("123456")
                .tipoLancamento(TipoLancamentoEnum.CREDITO)
                .dataLancamento(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();
        Mockito.when(lancamentoProviderPort.cadastrarLancamento(any(Lancamento.class))).thenReturn(lancamento);

        var result = cadastrarCreditoBusiness.cadastrarCredito(lancamento);

        Assertions.assertNotNull(result);

    }
}
