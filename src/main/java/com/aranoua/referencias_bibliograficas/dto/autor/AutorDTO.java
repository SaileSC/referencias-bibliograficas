package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.dto.artigo.ArtigoDTO;
import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;

import java.util.Set;
import java.util.stream.Collectors;

public record AutorDTO(long id, String nome, String afiliacao, Set<ArtigoDTO> artigos) {
    public static AutorDTO buildDTO(Autor autor) {
        return new AutorDTO(autor.getId(), autor.getNome(), autor.getAfiliacao(), listarArtigosParaDTO(autor.getArtigos()));
    }

    private static Set<ArtigoDTO> listarArtigosParaDTO(Set<Artigo> artigos){
        return artigos.stream()
                .map(ArtigoDTO::buildDTO)
                .collect(Collectors.toSet());
    }
}
