package com.htec.codingexercise.ui.fragment.list;

import com.htec.codingexercise.errorhandler.ErrorHandler;
import com.htec.codingexercise.ui.fragment.list.api.APIJsonData;
import com.htec.codingexercise.ui.fragment.list.dto.DTOElement;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.utils.rxutils.DefaultSubscriber;
import com.htec.codingexercise.utils.rxutils.MSchedulers;
import com.htec.codingexercise.utils.rxutils.Task;
import com.htec.codingexercise.utils.rxutils.TaskImp;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

public class JsonListInteractorImpl implements JsonListInteractor {

    private ErrorHandler errorHandler;
    private final APIJsonData api;
    private final MSchedulers schedulers;

    public JsonListInteractorImpl(ErrorHandler errorHandler, APIJsonData api, MSchedulers schedulers) {
        this.errorHandler = errorHandler;
        this.api = api;
        this.schedulers = schedulers;
    }

    @Override
    public Task getJson(JsonListListener listener) {

        Subscription s = api.getJsonData()
                .subscribeOn(schedulers.newThread())

                .flatMap(new Func1<List<DTOElement>, Observable<? extends DTOElement>>() {
                    @Override
                    public Observable<? extends DTOElement> call(List<DTOElement> dtoElements) {
                        return Observable.from(dtoElements);
                    }
                })

                .map(new Func1<DTOElement, ListElement>() {
                    @Override
                    public ListElement call(DTOElement dtoElement) {
                        return new ListElement(dtoElement);
                    }
                })

                .toList()
                .observeOn(schedulers.mainThread())
                .subscribe(new DefaultSubscriber<>(listener, errorHandler));

        return new TaskImp(s);
    }
}