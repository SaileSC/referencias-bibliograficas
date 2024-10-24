package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;
import com.aranoua.referencias_bibliograficas.repository.ArtigoRepository;

import java.util.Set;

public record AutorCreateDTO(String nome, String afiliacao) {
    public Autor toAutorEntity(ArtigoRepository repository){
        return new Autor(nome, afiliacao);
    }
}
