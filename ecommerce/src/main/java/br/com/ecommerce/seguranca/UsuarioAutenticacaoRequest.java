package br.com.ecommerce.seguranca;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsuarioAutenticacaoRequest {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken build() {
        return new UsernamePasswordAuthenticationToken(this.login,
                this.senha);
    }

}
