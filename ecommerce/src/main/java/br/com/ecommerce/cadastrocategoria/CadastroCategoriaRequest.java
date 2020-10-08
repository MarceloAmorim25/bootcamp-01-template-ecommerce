package br.com.ecommerce.cadastrocategoria;

import br.com.ecommerce.validacao.Unico;
import javax.validation.constraints.NotBlank;

public class CadastroCategoriaRequest {

    @NotBlank
    @Unico(fieldName = "nome", domainClass = Categoria.class)
    private String nome;

    private Long categoriaMaeId;

    public void setCategoriaMaeId(Long categoriaMaeId) {
        this.categoriaMaeId = categoriaMaeId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CadastroCategoriaRequest(@NotBlank String nome, Long categoriaMaeId) {
        this.nome = nome;
        this.categoriaMaeId = categoriaMaeId;
    }

    public Categoria converterParaTipoCategoria(){
        return new Categoria(nome,categoriaMaeId);
    }

}