package com.aranoua.referencias_bibliograficas.dto.artigo;


import java.util.Set;

public record ArtigoDTO(long id, String titulo, String ano_publicacao, String revista, Set<String> autores) {

}
