package com.htec.codingexercise.ui.fragment.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

public class FragmentDetails extends Fragment implements DetailsView {

    @Inject
    DetailsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // InjectorHelper.inject(this); TODO: Add Dagger implementation
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_quick_pick_layot, container, false);
//        ButterKnife.bind(this, view);
//
//        Logger.d(FragmentDetails.class, "onCreateView: " + this);
//
//        return view;
//    }
}