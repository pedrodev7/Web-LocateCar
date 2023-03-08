package br.com.ada.locatecar.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
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
