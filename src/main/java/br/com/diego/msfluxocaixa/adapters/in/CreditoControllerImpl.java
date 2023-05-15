package br.com.diego.msfluxocaixa.adapters.in;

import br.com.diego.msfluxocaixa.adapters.in.mapper.LancamentoRequestMapper;
import br.com.diego.msfluxocaixa.openapi.api.CreditoApi;
import br.com.diego.msfluxocaixa.openapi.dto.LancamentoRequest;
import br.com.diego.msfluxocaixa.ports.CreditoBusinessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditoControllerImpl implements CreditoApi {

    @Autowired
    private CreditoBusinessPort creditoBusinessPort;

    @Override
    public ResponseEntity<Void> cadastrarCredito(LancamentoRequest lancamentoRequest){
        creditoBusinessPort.cadastrarCredito(LancamentoRequestMapper.to(lancamentoRequest));
        return ResponseEntity.status(201).build();
    }
}
