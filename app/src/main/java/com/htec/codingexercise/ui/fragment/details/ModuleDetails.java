package com.htec.codingexercise.ui.fragment.details;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.errorhandler.ErrorHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleDetails {

    private final DetailsView view;

    public ModuleDetails(DetailsView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    public DetailsPresenter providePresenter(DetailsInteractor interactor) {
        return new DetailsPresenterImpl(interactor);
    }

    @PerActivity
    @Provides
    public DetailsInteractor provideInteractor(ErrorHandler errorHandler) {
        return new DetailsInteractorImpl(errorHandler);
    }
}