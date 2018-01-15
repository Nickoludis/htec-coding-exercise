package com.htec.codingexercise.ui.fragment.details;


import com.htec.codingexercise.errorhandler.ErrorHandler;

public class DetailsInteractorImpl implements DetailsInteractor {

    private ErrorHandler errorHandler;

    public DetailsInteractorImpl(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
}