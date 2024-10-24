package com.aranoua.referencias_bibliograficas.dto.revista_cientifica;

import com.aranoua.referencias_bibliograficas.model.RevistaCientifica;

public record RevistaCreateDTO(String nome, String ISSN){
    public RevistaCientifica toRevistaEntity(){
        return new RevistaCientifica(nome, ISSN);
    }
}
