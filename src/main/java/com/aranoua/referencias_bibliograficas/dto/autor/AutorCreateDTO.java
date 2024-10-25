package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Autor;


public record AutorCreateDTO(String nome, String afiliacao) {
    public Autor toAutorEntity(){
        return new Autor(nome, afiliacao);
    }
}
