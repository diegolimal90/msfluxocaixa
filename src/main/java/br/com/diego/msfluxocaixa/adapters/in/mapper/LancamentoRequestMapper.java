package br.com.diego.msfluxocaixa.adapters.in.mapper;

import br.com.diego.msfluxocaixa.core.domain.Lancamento;
import br.com.diego.msfluxocaixa.core.domain.enums.TipoLancamentoEnum;
import br.com.diego.msfluxocaixa.openapi.dto.LancamentoRequest;

import java.math.BigDecimal;
import java.util.Optional;

public class LancamentoRequestMapper {

    public static Lancamento to(LancamentoRequest mapper){
        return Optional.ofNullable(mapper).map(request -> Lancamento.builder()
                .valor(BigDecimal.valueOf(request.getValor()))
                .tipoLancamento(TipoLancamentoEnum.fromValue(request.getTipoLancamento().getValue()))
                .build()
        ).orElse(new Lancamento());
    }

    public static LancamentoRequest from(Lancamento mapper){
        return Optional.ofNullable(mapper).map(domain -> LancamentoRequest.builder()
                .valor(domain.getValor().doubleValue())
                .tipoLancamento(LancamentoRequest.TipoLancamentoEnum.fromValue(domain.getTipoLancamento().getValue()))
                .build()
        ).orElse(new LancamentoRequest());
    }
}
