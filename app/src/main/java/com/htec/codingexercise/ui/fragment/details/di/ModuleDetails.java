package com.htec.codingexercise.ui.fragment.details.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.ui.fragment.details.DetailsPresenter;
import com.htec.codingexercise.ui.fragment.details.DetailsPresenterImpl;
import com.htec.codingexercise.ui.fragment.details.DetailsView;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleDetails {

    private final DetailsView view;
    private final ListElement element;

    public ModuleDetails(DetailsView view, ListElement element) {
        this.view = view;
        this.element = element;
    }

    @PerActivity
    @Provides
    public DetailsPresenter providePresenter() {
        return new DetailsPresenterImpl(view, element);
    }
}