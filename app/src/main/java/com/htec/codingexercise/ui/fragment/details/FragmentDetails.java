package com.htec.codingexercise.ui.fragment.details;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.htec.codingexercise.R;
import com.htec.codingexercise.ui.widget.CustomFontTextView;
import com.htec.codingexercise.utils.InjectorHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentDetails extends Fragment implements DetailsView {

    @BindView(R.id.iv_details)
    SimpleDraweeView imageViewDetails;

    @BindView(R.id.tv_title_details)
    CustomFontTextView tvTitleDetails;

    @BindView(R.id.tv_description_details)
    CustomFontTextView tvDescriptionDetails;

    @Inject
    DetailsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectorHelper.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_layout, container, false);
        ButterKnife.bind(this, view);

        presenter.setDetailsData();

        return view;
    }

    @Override
    public void setImage(Uri imageUri) {
        imageViewDetails.setImageURI(imageUri);
    }

    @Override
    public void setTitle(String title) {
        tvTitleDetails.setText(title);
    }

    @Override
    public void setDescription(String description) {
        tvDescriptionDetails.setText(description);
    }
}