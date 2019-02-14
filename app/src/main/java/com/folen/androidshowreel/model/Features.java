package com.folen.androidshowreel.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import com.folen.androidshowreel.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

public class Features extends AbstractItem<Features, Features.ViewHolder> {

    public String name;
    public String description;
    public int image;

    public Features(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    @Override
    public int getType() {
        return R.id.list_card;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<Features> {
        View view;
        AppCompatTextView name;
        AppCompatTextView description;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.view = view.findViewById(R.id.list_card);
            name = view.findViewById(R.id.list_name);
            description = view.findViewById(R.id.list_description);
            image = view.findViewById(R.id.list_image);
        }

        @Override
        public void bindView(@NonNull Features item, @NonNull List<Object> payloads) {
            name.setText(item.name);
            description.setText(item.description);
            image.setImageResource(item.image);
        }

        @Override
        public void unbindView(@NonNull Features item) {
            name.setText(null);
            description.setText(null);
            image.setImageResource(0);
        }
    }
}
