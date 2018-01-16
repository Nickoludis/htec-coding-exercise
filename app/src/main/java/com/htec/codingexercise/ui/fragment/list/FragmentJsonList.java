package com.htec.codingexercise.ui.fragment.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.htec.codingexercise.R;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.ui.fragment.details.FragmentDetails;
import com.htec.codingexercise.ui.fragment.list.adapter.JsonListAdapter;
import com.htec.codingexercise.ui.fragment.list.adapter.JsonListDelegate;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.utils.InjectorHelper;
import com.htec.codingexercise.utils.Logger;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.htec.codingexercise.ui.fragment.Constants.DETAILS;

public class FragmentJsonList extends Fragment implements JsonListView, JsonListDelegate {

    @BindView(R.id.rv_json)
    RecyclerView recyclerView;

    @BindView(R.id.loading_progress_bar)
    ProgressBar loading_progress_bar;

    @Inject
    JsonListPresenter presenter;

    @Inject
    NavigationController navigationController;

    private JsonListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectorHelper.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_json_list_layout, container, false);

        ButterKnife.bind(this, view);

        Logger.d(FragmentJsonList.class, "onCreateView: " + this);

        initAdapter();

        presenter.loadJsonData();

        return view;
    }

    @Override
    public void onStop() {
        presenter.cancelLoading();
        super.onStop();
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new JsonListAdapter();
            adapter.setListDelegate(this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void setData(List<ListElement> result) {
        if (result == null) return;
        initAdapter();
        adapter.setData(result);
    }

    @Override
    public void showLoadingAnimation(boolean show) {
        loading_progress_bar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onItemClick(ListElement element) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(DETAILS, element);
        navigationController.loadPage(FragmentDetails.class).addToBackStack(true).isDialog(false).arguments(arguments).load();
    }
}
