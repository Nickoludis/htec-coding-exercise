package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

import java.util.List;

public interface JsonListView {

    /**
     * Provides loaded data to the view
     * @param result
     */
    void setData(List<ListElement> result);

    /**
     * Shows / hides loading animation.
     */
    void showLoadingAnimation(boolean show);
}