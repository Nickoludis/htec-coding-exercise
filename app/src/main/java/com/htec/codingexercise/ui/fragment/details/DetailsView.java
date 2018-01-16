package com.htec.codingexercise.ui.fragment.details;

import android.net.Uri;

public interface DetailsView {

    void setImage(Uri imageUri);

    void setTitle(String title);

    void setDescription(String description);
}