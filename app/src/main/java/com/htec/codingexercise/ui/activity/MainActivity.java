package com.htec.codingexercise.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.htec.codingexercise.ComponentProvider;
import com.htec.codingexercise.R;
import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.dialog.DialogManager;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.network.NNetworkInfo;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.network.NetworkStateReceiverListener;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;
import com.htec.codingexercise.ui.fragment.list.FragmentJsonList;
import com.htec.codingexercise.utils.InjectorHelper;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ComponentProvider, NetworkStateReceiverListener {

    private boolean networkStatusListenerSet = false;

    private ComponentActivity componentActivity;

    @Inject
    NavigationController navigationController;

    @Inject
    DialogManager dialogManager;

    @Inject
    NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        componentActivity = InjectorHelper.inject(this, R.id.main_fragment_container, getSupportFragmentManager());
        InjectorHelper.inject(this);

        setContentView(R.layout.activity_main_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigateToFragment();
    }

    public void navigateToFragment() {
        navigationController.loadPage(FragmentJsonList.class).addToBackStack(true).isDialog(false).animation(AnimationUtils.Transition.RIGHT_TO_LEFT).load();
    }

    @Override
    public <T> T component(Class<T> type) {
        if (ComponentActivity.class == type) {
            return (T) componentActivity;
        }
        ComponentProvider componentProvider = ((ComponentProvider) getApplication());
        return componentProvider.component(type);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!networkStatusListenerSet) {
            networkManager.addListener(this);
            networkStatusListenerSet = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        networkManager.removeListener(this);
    }

    @Override
    public void onBackPressed() {
        if (navigationController.canGoBack()) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    @Override
    public void onNetworkStateChange(NNetworkInfo info) {
        if (!info.isConnected()) {
            dialogManager.noInternetDialog(null, null);
        }
    }
}
