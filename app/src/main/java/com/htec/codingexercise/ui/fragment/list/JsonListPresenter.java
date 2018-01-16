package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.network.NNetworkInfo;

public interface JsonListPresenter {

    void loadJsonData();

    void cancelLoading();

    void onNetworkChange(NNetworkInfo info);

    void onDestroy();
}