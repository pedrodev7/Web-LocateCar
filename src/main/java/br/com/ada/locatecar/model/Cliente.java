package br.com.ada.locatecar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Cliente {
    
    private String nome;
    private String endereco;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;

}
