package com.htec.codingexercise.ui.fragment.details;

import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

public class DetailsPresenterImpl implements DetailsPresenter {

    private final DetailsView view;
    private final ListElement element;

    public DetailsPresenterImpl(DetailsView view, ListElement element) {
        this.view = view;
        this.element = element;
    }

    @Override
    public void setDetailsData() {
        view.setImage(element.imageUri);
        view.setTitle(element.title);
        view.setDescription(element.description);
    }
}