package com.aranoua.referencias_bibliograficas.dto.artigo;


import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;

import java.util.Set;
import java.util.stream.Collectors;

public record ArtigoDTO(long id, String titulo, String ano_publicacao, String revista, Set<String> autores) {
    public static ArtigoDTO buildDTO(Artigo artigo){
        return new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), artigo.getRevista().getNome(), obterNomes(artigo.getAutores()) );
    }

    private static Set<String> obterNomes(Set<Autor> autores){
        return autores.stream()
                .map(Autor::getNome)
                .collect(Collectors.toSet());
    }
}
