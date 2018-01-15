package com.htec.codingexercise.ui.fragment.details;

public class DetailsPresenterImpl implements DetailsPresenter {

    private DetailsInteractor interactor;

    public DetailsPresenterImpl(DetailsInteractor interactor) {
        this.interactor = interactor;
    }
}