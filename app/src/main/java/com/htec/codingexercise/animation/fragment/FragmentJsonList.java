package com.htec.codingexercise.animation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htec.codingexercise.R;

/**
 * Created by Nikola Brankovic - branick2005@gmail.com on 1/13/18.
 */

public class FragmentJsonList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_json_list_layout, container, false);

        return view;
    }


}
