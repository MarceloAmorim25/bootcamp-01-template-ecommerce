package br.com.ecommerce.cadastrocategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid CadastroCategoriaRequest cadastroCategoriaRequest){

        Categoria categoria = cadastroCategoriaRequest.converterParaTipoCategoria();

        categoriaRepository.save(categoria);

        return ResponseEntity
                .ok()
                .build();

    }
}
