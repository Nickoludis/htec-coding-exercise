package com.htec.codingexercise.ui.fragment.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.htec.codingexercise.R;
import com.htec.codingexercise.ui.fragment.list.FragmentJsonList;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;
import com.htec.codingexercise.ui.widget.CustomFontTextView;

import java.util.ArrayList;
import java.util.List;

public class JsonListAdapter extends RecyclerView.Adapter<JsonListAdapter.JsonItemViewHolder> implements View.OnClickListener {

    private List<ListElement> jsonList = new ArrayList<>();
    private JsonListDelegate jsonListDelegate;

    public void setData(@NonNull List<ListElement> resultList) {
        jsonList.addAll(resultList);
        notifyDataSetChanged();
    }

    /**
     * Delegate which establishes connection with view {@link FragmentJsonList}
     *
     * @param jsonListDelegate instance of {@link JsonListDelegate}
     */
    public void setListDelegate(@NonNull JsonListDelegate jsonListDelegate) {
        this.jsonListDelegate = jsonListDelegate;
    }

    @Override
    public void onBindViewHolder(JsonItemViewHolder holder, int position) {

        ListElement listElement = jsonList.get(position);

        if (listElement != null) {
            holder.layoutHolder.setTag(R.id.item_details_id, listElement);
        }

        if (listElement.imageUri != null) {
            holder.imageView.setImageURI(listElement.imageUri);
        } else {
            holder.imageView.setImageURI("");
        }

        if (listElement.title != null) {
            holder.tvTitle.setText(listElement.title);
        } else {
            holder.tvTitle.setText("");
        }

        if (listElement.description != null) {
            holder.tvDescription.setText(listElement.description);
        } else {
            holder.tvDescription.setText("");
        }

        holder.layoutHolder.setOnClickListener(this);
    }

    @Override
    public JsonItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new JsonItemViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        if (jsonList != null) {
            return jsonList.size();
        }
        return 0;
    }

    @Override
    public void onClick(View view) {
        jsonListDelegate.onItemClick((ListElement) view.getTag(R.id.item_details_id));
    }

    public class JsonItemViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout layoutHolder;
        public SimpleDraweeView imageView;
        public CustomFontTextView tvTitle, tvDescription;

        public JsonItemViewHolder(View view) {
            super(view);
            layoutHolder = view.findViewById(R.id.layout_holder);
            imageView = view.findViewById(R.id.iv);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDescription = view.findViewById(R.id.tv_description);
        }
    }
}
