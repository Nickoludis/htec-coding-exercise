package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

import java.util.List;

public interface JsonListView {

    void setData(List<ListElement> result);

    /**
     * Show / hide loading animation.
     */
    void showLoadingAnimation(boolean show);
}