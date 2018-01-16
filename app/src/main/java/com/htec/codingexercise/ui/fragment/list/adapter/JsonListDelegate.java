package com.htec.codingexercise.ui.fragment.list.adapter;

import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

public interface JsonListDelegate {

    /**
     * Propagates list item click event to the fragment.
     *
     * @param element list element data
     */
    void onItemClick(ListElement element);
}
