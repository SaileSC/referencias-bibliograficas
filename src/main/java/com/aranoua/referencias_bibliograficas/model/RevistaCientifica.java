package com.aranoua.referencias_bibliograficas.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "revistas_cientificas")
public class RevistaCientifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String ISSN;
    @OneToMany(mappedBy = "revista")
    private Set<Artigo> artigosPublicados = new HashSet<>();

    public RevistaCientifica() {
    }

    public RevistaCientifica(String nome, String ISSN) {
        this.nome = nome;
        this.ISSN = ISSN;
    }

    public RevistaCientifica(long id, String nome, String ISSN, Set<Artigo> artigosPublicados) {
        this.id = id;
        this.nome = nome;
        this.ISSN = ISSN;
        this.artigosPublicados = artigosPublicados;
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

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public Set<Artigo> getArtigosPublicados() {
        return artigosPublicados;
    }

    public void setArtigosPublicados(Set<Artigo> artigosPublicados) {
        this.artigosPublicados = artigosPublicados;
    }
}
