package com.aranoua.referencias_bibliograficas.dto.revista_cientifica;

import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.RevistaCientifica;

import java.util.Set;

public record RevistaDTO(long id, String nome, String ISSN, Set<Artigo> artigosPublicados){
    public static RevistaDTO buildDTO(RevistaCientifica revista){
        return new RevistaDTO(revista.getId(), revista.getNome(), revista.getISSN(), revista.getArtigosPublicados());
    }
}
