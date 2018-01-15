package com.htec.codingexercise.ui.fragment.list.dto;

import java.io.Serializable;

public class ListElement implements Serializable {

    public final String image;
    public final String description;
    public final String title;

    public ListElement(DTOElement dtoElement) {
        this.image = dtoElement.image;
        this.description = dtoElement.description;
        this.title = dtoElement.title;
    }
}
