package br.com.diego.msfluxocaixa.adpters.out;

import br.com.diego.msfluxocaixa.adapters.out.providers.LancamentoProvider;
import br.com.diego.msfluxocaixa.adapters.out.repository.LancamentoRepository;
import br.com.diego.msfluxocaixa.adapters.out.repository.entities.LancamentoEntity;
import br.com.diego.msfluxocaixa.config.exception.DataBaseException;
import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.core.domain.enums.TipoLancamentoEnum;
import com.mongodb.MongoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class LancamentoProviderTest {

    @Mock
    private LancamentoRepository lancamentoRepository;

    @InjectMocks
    private LancamentoProvider lancamentoProvider;

    @Test
    public void buscarLancamentosSuccess() {
        Lancamento domain = Lancamento.builder()
                .tipoLancamento(TipoLancamentoEnum.CREDITO)
                .dataLancamento(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();
        LancamentoEntity entity = LancamentoEntity.builder()
                .id("123456")
                .tipoLancamento(TipoLancamentoEnum.CREDITO.getValue())
                .dataCriacao(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();

        Mockito.when(lancamentoRepository.insert(
                any(LancamentoEntity.class))).thenReturn(entity);

        var result = lancamentoProvider.cadastrarLancamento(domain);


        Assertions.assertNotNull(result);
        Assertions.assertEquals(Objects.requireNonNull(result).getIdLancamento(), entity.getId());
    }

    @Test
    public void buscarLancamentosException() {
        Lancamento domain = Lancamento.builder()
                .tipoLancamento(TipoLancamentoEnum.CREDITO)
                .dataLancamento(LocalDateTime.now())
                .valor(BigDecimal.valueOf(200.00))
                .build();

        Mockito.doThrow(MongoException.class).when(lancamentoRepository).insert(
                any(LancamentoEntity.class));

        Assertions.assertThrows(DataBaseException.class, () -> lancamentoProvider.cadastrarLancamento(domain));
    }
}
