package br.com.ecommerce.cadastroproduto;

import br.com.ecommerce.cadastrocategoria.Categoria;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

public class CadastroProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private Double valor;

    @NotNull
    @Positive
    private Long quantidadeDisponivel;

    @ElementCollection
    private List<Caracteristica> caracteristicas;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    private Long categoriaId;

    public CadastroProdutoRequest(@NotBlank String nome, @NotBlank @Positive Double valor, @NotBlank @Positive Long quantidadeDisponivel,
                                  @Size(min = 3) List<Caracteristica> caracteristicas, @NotBlank @Size(max = 1000) String descricao,
                                  @NotNull Long categoriaId) {

        this.nome = nome;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.categoriaId = categoriaId;

    }

    public Produto converteParaTipoProduto(EntityManager entityManager) {

        Categoria categoria = entityManager.find(Categoria.class, categoriaId);

        return new Produto(nome, valor, quantidadeDisponivel, caracteristicas, descricao, categoria);

    }


}