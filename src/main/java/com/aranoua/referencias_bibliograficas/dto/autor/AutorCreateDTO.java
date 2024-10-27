package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Autor;
import jakarta.validation.constraints.NotBlank;


public record AutorCreateDTO(
        @NotBlank(message = "nome não pode ser vazio.")
        String nome,
        @NotBlank(message = "afiliacao não pode ser vazio.")
        String afiliacao) {
    public Autor toAutorEntity(){
        return new Autor(nome, afiliacao);
    }
}
