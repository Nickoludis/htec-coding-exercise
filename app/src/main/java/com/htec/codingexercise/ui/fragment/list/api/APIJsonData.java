package com.htec.codingexercise.ui.fragment.list.api;

import com.htec.codingexercise.ui.fragment.list.dto.DTOElement;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface APIJsonData {
    @GET("danieloskarsson/mobile-coding-exercise/master/items.json")
    Observable<List<DTOElement>> getJsonData();
}