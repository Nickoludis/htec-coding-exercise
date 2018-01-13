package com.htec.codingexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.animation.fragment.FragmentJsonList;
import com.htec.codingexercise.navigation.FragmentTransactionExecutorImpl;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.navigation.NavigationControllerImpl;

/**
 * Created by Nikola Brankovic - branick2005@gmail.com on 1/12/18.
 */

public class MainActivity extends AppCompatActivity {

    NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationController = new NavigationControllerImpl(new FragmentTransactionExecutorImpl(R.id.main_fragment_container, getSupportFragmentManager()));

        navigateToFragment();
    }

    public void navigateToFragment() {
        navigationController.loadPage(FragmentJsonList.class).addToBackStack(true).isDialog(false).animation(AnimationUtils.Transition.LEFT_TO_RIGHT).load();
    }
}
