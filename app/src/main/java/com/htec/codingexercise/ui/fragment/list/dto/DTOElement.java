package com.htec.codingexercise.ui.fragment.list.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class DTOElement {
    public final String image;
    public final String description;
    public final String title;

    @JsonCreator
    public DTOElement(@JsonProperty("image") String image, @JsonProperty("description") String description, @JsonProperty("title") String title) {
        this.image = image;
        this.description = description;
        this.title = title;
    }
}
