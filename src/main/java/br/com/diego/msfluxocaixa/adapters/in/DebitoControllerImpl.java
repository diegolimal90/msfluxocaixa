package br.com.diego.msfluxocaixa.adapters.in;

import br.com.diego.msfluxocaixa.adapters.in.mapper.LancamentoRequestMapper;
import br.com.diego.msfluxocaixa.openapi.api.DebitoApi;
import br.com.diego.msfluxocaixa.openapi.dto.LancamentoRequest;
import br.com.diego.msfluxocaixa.ports.DebitoBusinessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebitoControllerImpl implements DebitoApi {

    @Autowired
    private DebitoBusinessPort debitoBusinessPort;

    @Override
    public ResponseEntity<Void> cadastrarDebito(LancamentoRequest lancamentoRequest){
        debitoBusinessPort.cadastrarDebito(LancamentoRequestMapper.to(lancamentoRequest));
        return ResponseEntity.status(201).build();
    }
}
