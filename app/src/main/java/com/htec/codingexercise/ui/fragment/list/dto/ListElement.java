package com.htec.codingexercise.ui.fragment.list.dto;

import android.net.Uri;

import java.io.Serializable;

public class ListElement implements Serializable {

    public final Uri imageUri;
    public final String description;
    public final String title;

    public ListElement(DTOElement dtoElement) {
        this.imageUri = Uri.parse(dtoElement.image);
        this.description = dtoElement.description;
        this.title = dtoElement.title;
    }
}
