package br.com.diego.msfluxocaixa.adpters.in;


import br.com.diego.msfluxocaixa.adapters.in.DebitoControllerImpl;
import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.core.domain.enums.TipoLancamentoEnum;
import br.com.diego.msfluxocaixa.openapi.dto.LancamentoRequest;
import br.com.diego.msfluxocaixa.ports.DebitoBusinessPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DebitoControllerImplTest {

    @Mock
    private DebitoBusinessPort debitoBusinessPort;
    @InjectMocks
    private DebitoControllerImpl debitoController;

    @Test
    public void cadastrarDebitoSuccess(){
        var lancamento = Lancamento.builder()
                .tipoLancamento(TipoLancamentoEnum.CREDITO)
                .dataLancamento(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();

        var lancamentoRequest = LancamentoRequest.builder()
                .tipoLancamento(LancamentoRequest.TipoLancamentoEnum.CREDITO)
                .valor(200.00D)
                .build();

        Mockito.when(debitoBusinessPort.cadastrarDebito(any())).thenReturn(lancamento);

        var responseEntity = debitoController.cadastrarDebito(lancamentoRequest);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }
}
