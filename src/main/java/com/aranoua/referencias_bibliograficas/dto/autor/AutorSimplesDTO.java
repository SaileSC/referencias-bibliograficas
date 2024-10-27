package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Autor;


public record AutorSimplesDTO(long id, String nome, String afiliacao) {
    public static AutorSimplesDTO buildDTO(Autor autor) {
        return new AutorSimplesDTO(autor.getId(), autor.getNome(), autor.getAfiliacao());
    }
}
