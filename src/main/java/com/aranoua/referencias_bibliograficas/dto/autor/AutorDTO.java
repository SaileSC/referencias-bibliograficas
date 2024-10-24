package com.aranoua.referencias_bibliograficas.dto.autor;

import com.aranoua.referencias_bibliograficas.model.Artigo;

import java.util.Set;

public record AutorDTO(long id, String nome, String afiliacao, Set<Artigo> artigos) {
}
