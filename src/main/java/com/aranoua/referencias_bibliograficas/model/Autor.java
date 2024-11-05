package com.aranoua.referencias_bibliograficas.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne(optional = false)
    @JoinColumn(name = "afiliacao_id", nullable = false)
    private Afiliacao afiliacao;

    @ManyToMany
    @JoinTable(
            name = "artigo_autor",
            joinColumns = @JoinColumn(name ="autor_id"),
            inverseJoinColumns = @JoinColumn(name = "artigo_id")
    )
    private Set<Artigo> artigos = new HashSet<>();

    public Autor() {
    }

    public Autor(long id, String nome, Afiliacao afiliacao, Set<Artigo> artigos) {
        this.id = id;
        this.nome = nome;
        this.afiliacao = afiliacao;
        this.artigos = artigos;
    }

    public Autor(String nome, Afiliacao afiliacao) {
        this.nome = nome;
        this.afiliacao = afiliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Afiliacao getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(Afiliacao afiliacao) {
        this.afiliacao = afiliacao;
    }

    public Set<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(Set<Artigo> artigos) {
        this.artigos = artigos;
    }
}
