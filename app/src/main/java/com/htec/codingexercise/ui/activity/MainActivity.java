package com.htec.codingexercise.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.htec.codingexercise.ComponentProvider;
import com.htec.codingexercise.R;
import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.ui.fragment.FragmentJsonList;
import com.htec.codingexercise.utils.InjectorHelper;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ComponentProvider {

    private ComponentActivity componentActivity;

    @Inject
    NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ComponentApp componentApp = component(ComponentApp.class);
//        componentActivity = componentApp.get(new ModuleErrorHandler(this));

        componentActivity = InjectorHelper.inject(this);
        InjectorHelper.inject(this, R.id.main_fragment_container, getSupportFragmentManager());

        setContentView(R.layout.activity_main_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigateToFragment();
    }

    public void navigateToFragment() {
        navigationController.loadPage(FragmentJsonList.class).addToBackStack(true).isDialog(false).animation(AnimationUtils.Transition.LEFT_TO_RIGHT).load();
    }

    @Override
    public <T> T component(Class<T> type) {
        if (ComponentActivity.class == type) {
            return (T) componentActivity;
        }
        ComponentProvider componentProvider = ((ComponentProvider) getApplication());
        return componentProvider.component(type);
    }
}
