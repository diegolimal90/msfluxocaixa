package br.com.diego.msfluxocaixa.business;

import br.com.diego.msfluxocaixa.core.business.CadastrarDebitoBusiness;
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
public class CadastrarDebitoBusinessTest {

    @Mock
    private LancamentoProviderPort lancamentoProviderPort;
    @InjectMocks
    private CadastrarDebitoBusiness cadastrarDebitoBusiness;

    @Test
    void cadastrarDebitoSuccess(){
        Lancamento lancamento = Lancamento.builder()
                .idLancamento("123456")
                .tipoLancamento(TipoLancamentoEnum.DEBITO)
                .dataLancamento(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();
        Mockito.when(lancamentoProviderPort.cadastrarLancamento(any(Lancamento.class))).thenReturn(lancamento);

        var result = cadastrarDebitoBusiness.cadastrarDebito(lancamento);

        Assertions.assertNotNull(result);

    }
}
