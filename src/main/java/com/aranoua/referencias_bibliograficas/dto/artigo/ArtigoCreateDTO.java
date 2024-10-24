package com.aranoua.referencias_bibliograficas.dto.artigo;


import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;
import com.aranoua.referencias_bibliograficas.model.RevistaCientifica;
import com.aranoua.referencias_bibliograficas.repository.AutorRepository;
import com.aranoua.referencias_bibliograficas.repository.RevistaCientificaRepository;
import com.aranoua.referencias_bibliograficas.service.exception.ObjectNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

public record ArtigoCreateDTO(String titulo, String ano_publicacao, String revista, Set<String> autores) {
    public Artigo toArtigoEntity(RevistaCientificaRepository revistaRepository, AutorRepository autorRepository){
        RevistaCientifica revista = encontrarRevista(revistaRepository);
        Set<Autor> listaAutores = encontrarAutores(autorRepository);
        return new Artigo(titulo, ano_publicacao, revista, listaAutores);
    }

    private RevistaCientifica encontrarRevista(RevistaCientificaRepository repository){
        return  repository.findByNome(revista).orElseThrow(()->
                new ObjectNotFoundException("Revista não encontrada NOME:" + revista));
    }

    private Set<Autor> encontrarAutores(AutorRepository repository){
        return autores.stream()
                .map(nomeAutor ->
                        repository.findByNome(nomeAutor).orElseThrow(()->
                                new ObjectNotFoundException("Autor não encontrado NOME:"+ nomeAutor)))
                .collect(Collectors.toSet());
    }
}
