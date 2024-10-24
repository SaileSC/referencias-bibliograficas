package com.aranoua.referencias_bibliograficas.service;

import com.aranoua.referencias_bibliograficas.dto.autor.AutorCreateDTO;
import com.aranoua.referencias_bibliograficas.dto.autor.AutorDTO;
import com.aranoua.referencias_bibliograficas.model.Autor;
import com.aranoua.referencias_bibliograficas.repository.ArtigoRepository;
import com.aranoua.referencias_bibliograficas.repository.AutorRepository;
import com.aranoua.referencias_bibliograficas.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public Set<AutorDTO> list(){
        return autorRepository.findAll().stream()
                .map(AutorDTO::buildDTO)
                .collect(Collectors.toSet());
    }

    public AutorDTO read(long id){
        return AutorDTO.buildDTO(encontrarAutor(id));
    }

    public AutorDTO create(AutorCreateDTO autor){
        try {
            return AutorDTO.buildDTO(
                    autorRepository.save(autor.toAutorEntity())
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public AutorDTO update(long id, AutorCreateDTO body){
        try {
            Autor autor = encontrarAutor(id);
            autor.setNome(body.nome());
            autor.setAfiliacao(body.afiliacao());
            return AutorDTO.buildDTO(autorRepository.save(autor));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try {
            autorRepository.delete(encontrarAutor(id));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private Autor encontrarAutor(long id){
        return autorRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Autor não encontrado AUTOR_ID" + id));
    }
}
