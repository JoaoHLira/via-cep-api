package br.com.joaolirarosas.via_cep.endereco.api;

import br.com.joaolirarosas.via_cep.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class CepController {

    private final CepFeignService cepFeignService;

    @GetMapping("/{cep}")
    @ResponseStatus(code = HttpStatus.OK)
    public Endereco getEnderecoByCEP(@PathVariable("cep") String cep) {
        EnderecoDTO endereco = cepFeignService.buscaEnderecoPorCEP(cep);
        return new Endereco(endereco);
    }
}
