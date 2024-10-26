package com.aranoua.referencias_bibliograficas.service;

import com.aranoua.referencias_bibliograficas.dto.artigo.ArtigoCreateDTO;
import com.aranoua.referencias_bibliograficas.dto.artigo.ArtigoDTO;
import com.aranoua.referencias_bibliograficas.dto.revista_cientifica.RevistaCreateDTO;
import com.aranoua.referencias_bibliograficas.dto.revista_cientifica.RevistaDTO;
import com.aranoua.referencias_bibliograficas.model.Artigo;
import com.aranoua.referencias_bibliograficas.model.Autor;
import com.aranoua.referencias_bibliograficas.model.RevistaCientifica;
import com.aranoua.referencias_bibliograficas.repository.ArtigoRepository;
import com.aranoua.referencias_bibliograficas.repository.AutorRepository;
import com.aranoua.referencias_bibliograficas.repository.RevistaCientificaRepository;
import com.aranoua.referencias_bibliograficas.service.exception.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArtigoService {
    @Autowired
    RevistaCientificaRepository revistaRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    ArtigoRepository artigoRepository;

    public Set<ArtigoDTO> list(){
        return artigoRepository.findAll().stream()
                .map(ArtigoDTO::buildDTO)
                .collect(Collectors.toSet());
    }

    public ArtigoDTO read(long id){
        return ArtigoDTO.buildDTO(encontrarArtigo(id));
    }

    public ArtigoDTO create(ArtigoCreateDTO body){
        try {
            return ArtigoDTO.buildDTO(
                    artigoRepository.save(body.toArtigoEntity(revistaRepository, autorRepository))
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ArtigoDTO update(long id, ArtigoCreateDTO body) {
        try {
            Artigo artigo = encontrarArtigo(id);

            artigo.setTitulo(body.titulo());
            artigo.setAnoPublicacao(body.ano_publicacao());

            if (body.revista() != null) {
                RevistaCientifica revista = revistaRepository.findByNome(body.revista())
                        .orElseThrow(() -> new ObjectNotFoundException("Revista não encontrada: " + body.revista()));
                artigo.setRevista(revista);
            }

            if (body.autores() != null) {
                List<Autor> listaAutores = body.autores().stream()
                        .map(nomeAutor -> autorRepository.findByNome(nomeAutor)
                                .orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado: " + nomeAutor)))
                        .toList();

                artigo.getAutores().forEach(autor -> {
                    if(!listaAutores.contains(autor)){
                        autor.getArtigos().remove(artigo);
                    }
                });

                listaAutores.forEach(autor -> autor.getArtigos().add(artigo));

                artigo.getAutores().clear();
                artigo.getAutores().addAll(listaAutores);
            }

            return ArtigoDTO.buildDTO(artigoRepository.save(artigo));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(long id){
        try {
            artigoRepository.delete(encontrarArtigo(id));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private Artigo encontrarArtigo(long id){
        return artigoRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Artigo não encontrado ARTIGO_ID: " + id));
    }
}
