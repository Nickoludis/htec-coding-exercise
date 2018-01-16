package com.htec.codingexercise.ui.fragment.list.dto;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class ListElement implements Parcelable {

    public final Uri imageUri;
    public final String description;
    public final String title;

    public ListElement(DTOElement dtoElement) {
        this.imageUri = Uri.parse(dtoElement.image);
        this.description = dtoElement.description;
        this.title = dtoElement.title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.imageUri, flags);
        dest.writeString(this.description);
        dest.writeString(this.title);
    }

    protected ListElement(Parcel in) {
        this.imageUri = in.readParcelable(Uri.class.getClassLoader());
        this.description = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<ListElement> CREATOR = new Parcelable.Creator<ListElement>() {
        @Override
        public ListElement createFromParcel(Parcel source) {
            return new ListElement(source);
        }

        @Override
        public ListElement[] newArray(int size) {
            return new ListElement[size];
        }
    };
}
