package com.aranoua.referencias_bibliograficas.dto.revista_cientifica;

import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.RevistaCientifica;

import java.util.Set;

public record RevistaSimplesDTO(long id, String nome, String ISSN){
    public static RevistaSimplesDTO buildDTO(RevistaCientifica revista){
        return new RevistaSimplesDTO(revista.getId(), revista.getNome(), revista.getISSN());
    }
}
