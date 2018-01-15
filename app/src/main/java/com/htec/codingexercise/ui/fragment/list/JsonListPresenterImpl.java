package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.utils.rxutils.Task;

import java.util.List;

public class JsonListPresenterImpl implements JsonListPresenter {

    private JsonListView view;
    private JsonListInteractor interactor;

    private Task loadTask;

    public JsonListPresenterImpl(JsonListView view, JsonListInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadJsonData() {
        view.showLoadingAnimation(true);
        executeLoadJob();
    }

    private void executeLoadJob() {

        if (loadTask == null || loadTask.isEnded()) {

            loadTask = interactor.getJson(new JsonListInteractor.JsonListListener() {
                @Override
                public boolean onError(Throwable error) {
                    view.showLoadingAnimation(false);
                    return false;
                }

                @Override
                public void onCompleted() {
                    view.showLoadingAnimation(false);
                }

                @Override
                public void onResult(List<ListElement> result) {
                    view.setData(result);
                }
            });
        }
    }

    @Override
    public void cancelLoading() {
        if (loadTask != null) loadTask.end();
    }
}