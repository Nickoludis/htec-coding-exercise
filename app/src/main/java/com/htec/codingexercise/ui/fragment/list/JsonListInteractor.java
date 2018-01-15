package com.htec.codingexercise.ui.fragment.list;


import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.utils.rxutils.PresenterCallbackErrorHandler;
import com.htec.codingexercise.utils.rxutils.PresenterCallbackOnCompleted;
import com.htec.codingexercise.utils.rxutils.PresenterCallbackOnResult;
import com.htec.codingexercise.utils.rxutils.Task;

import java.util.List;

public interface JsonListInteractor {

    interface JsonListListener extends
            PresenterCallbackOnCompleted,
            PresenterCallbackOnResult<List<ListElement>>,
            PresenterCallbackErrorHandler {
    }

    Task getJson(JsonListListener listener);
}