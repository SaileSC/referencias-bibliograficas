package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;

import java.util.Set;

public record AutorDTO(long id, String nome, String afiliacao, Set<Artigo> artigos) {
    public static AutorDTO buildDTO(Autor autor) {
        return new AutorDTO(autor.getId(), autor.getNome(), autor.getAfiliacao(), autor.getArtigos());
    }
}
