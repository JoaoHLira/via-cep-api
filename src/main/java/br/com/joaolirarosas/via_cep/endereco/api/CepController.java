package br.com.joaolirarosas.via_cep.endereco.api;

import br.com.joaolirarosas.via_cep.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Log4j2
public class CepController {

    private final CepFeignService cepFeignService;

    @GetMapping("/{cep}")
    @ResponseStatus(code = HttpStatus.OK)
    public Endereco getEnderecoByCEP(@PathVariable("cep") String cep) {
        log.info("[start] CepController - getEnderecoByCEP");
        EnderecoDTO endereco = cepFeignService.buscaEnderecoPorCEP(cep);
        log.debug("[finish] CepController - getEnderecoByCEP");
        return new Endereco(endereco);
    }
}
