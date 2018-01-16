package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.network.NNetworkInfo;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.network.NetworkStateReceiverListener;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.utils.rxutils.Task;

import java.util.List;

public class JsonListPresenterImpl implements JsonListPresenter, NetworkStateReceiverListener {

    private JsonListView view;
    private JsonListInteractor interactor;
    private final NetworkManager networkManager;

    private Task loadTask;
    protected boolean networkStatusListenerSet = false;

    public JsonListPresenterImpl(JsonListView view, JsonListInteractor interactor, NetworkManager networkManager) {
        this.view = view;
        this.interactor = interactor;
        this.networkManager = networkManager;
    }

    @Override
    public void loadJsonData() {
        if (!networkStatusListenerSet) {
            networkManager.addListener(this);
            networkStatusListenerSet = true;
        }
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

    @Override
    public void onNetworkChange(NNetworkInfo info) {
        if (info.isConnected()) {
            loadJsonData();
        }
    }

    @Override
    public void onDestroy() {
        networkManager.removeListener(this);
    }

    @Override
    public void onNetworkStateChange(NNetworkInfo info) {
        onNetworkChange(info);
    }
}