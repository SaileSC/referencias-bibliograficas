package com.aranoua.referencias_bibliograficas.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artigos")
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false, name = "ano_publicacao")
    private String anoPublicacao;
    @ManyToOne
    private RevistaCientifica revista;
    @ManyToMany(mappedBy = "artigos")
    private Set<Autor> autores = new HashSet<>();

    public Artigo() {
    }

    public Artigo(long id, String titulo, String anoPublicacao, RevistaCientifica revista, Set<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.revista = revista;
        this.autores = autores;
    }

    public Artigo(String titulo, String anoPublicacao, RevistaCientifica revista, Set<Autor> autores){
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.revista = revista;
        this.autores = autores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public RevistaCientifica getRevista() {
        return revista;
    }

    public void setRevista(RevistaCientifica revista) {
        this.revista = revista;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
}
