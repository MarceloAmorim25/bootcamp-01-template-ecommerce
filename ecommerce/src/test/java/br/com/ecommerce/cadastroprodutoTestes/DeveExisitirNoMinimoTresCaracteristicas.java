package br.com.ecommerce.cadastroprodutoTestes;

import br.com.ecommerce.cadastrocategoria.Categoria;
import br.com.ecommerce.cadastroproduto.Caracteristica;
import br.com.ecommerce.cadastroproduto.Produto;
import br.com.ecommerce.cadastrousuario.SenhaLimpa;
import br.com.ecommerce.cadastrousuario.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DeveExisitirNoMinimoTresCaracteristicas {


    private Validator validador;

    private Categoria categoria;

    private Usuario usuario;

    private List<Caracteristica> caracteristicas;


    @Before
    public void SetUp(){


        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        validador = factory.getValidator();

        categoria = new Categoria("Testando");

        usuario = new Usuario("usuariotesteproduto@email.com", new SenhaLimpa("testando"));


        caracteristicas = Arrays.asList(
                new Caracteristica("teste 1", new BigDecimal(120)),
                new Caracteristica("teste 2", new BigDecimal(120))
        );

    }

    @Test
    public void deveTerMaisDeTrêsCaracteristicasNoProduto(){


        Produto produtoComMenosDeTresCaracteristicas = new Produto("Produto Teste", new BigDecimal(30), Long.parseLong("120"),
                caracteristicas, "descricao do produto", categoria, usuario);


        Set<ConstraintViolation<Produto>> errosDeValidacao = validador.validate(produtoComMenosDeTresCaracteristicas);


        Assert.assertTrue(errosDeValidacao.size() >= 1);

    }

}
