package br.com.joaolirarosas.via_cep.endereco.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepFeignService {

    @GetMapping("{cep}/json")
    EnderecoDTO buscaEnderecoPorCEP(@PathVariable("cep") String cep);
}
