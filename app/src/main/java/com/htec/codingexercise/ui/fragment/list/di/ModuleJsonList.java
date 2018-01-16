package com.htec.codingexercise.ui.fragment.list.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.errorhandler.ErrorHandler;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.ui.fragment.list.JsonListInteractor;
import com.htec.codingexercise.ui.fragment.list.JsonListInteractorImpl;
import com.htec.codingexercise.ui.fragment.list.JsonListPresenter;
import com.htec.codingexercise.ui.fragment.list.JsonListPresenterImpl;
import com.htec.codingexercise.ui.fragment.list.JsonListView;
import com.htec.codingexercise.ui.fragment.list.api.APIJsonData;
import com.htec.codingexercise.utils.rxutils.MSchedulers;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.htec.codingexercise.network.http.Constants.RETROFIT_API;

@Module
public class ModuleJsonList {

    private final JsonListView view;

    public ModuleJsonList(JsonListView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    public JsonListPresenter providePresenter(JsonListInteractor interactor, NetworkManager networkManager) {
        return new JsonListPresenterImpl(view, interactor, networkManager);
    }

    @PerActivity
    @Provides
    public JsonListInteractor provideInteractor(ErrorHandler errorHandler, APIJsonData apiJsonData, MSchedulers schedulers) {
        return new JsonListInteractorImpl(errorHandler, apiJsonData, schedulers);
    }

    /**
     * Provides retrofit API
     */
    @PerActivity
    @Provides
    public APIJsonData provideAPI(@Named(RETROFIT_API) Retrofit retrofit) {
        return retrofit.create(APIJsonData.class);
    }
}