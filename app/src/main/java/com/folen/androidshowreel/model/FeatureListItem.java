package com.folen.androidshowreel.model;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import com.folen.androidshowreel.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

public class FeatureListItem extends AbstractItem<FeatureListItem, FeatureListItem.ViewHolder> {

    private static final int NULL_IMAGE = 0;
    private String name, description;
    private Intent intent;
    private int image;


    public FeatureListItem(Feature feature) {
    }

    public class Feature(String name, String description, @DrawableRes int image, Intent intent) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage {
        return image;
    }

    public Intent getIntent() {
        return intent;
    }


    @Override
    public int getType() {
        return R.id.list_item_layout;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<FeatureListItem> {
        View view;
        AppCompatTextView name, description;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.view = view.findViewById(R.id.list_card);
            name = view.findViewById(R.id.list_name);
            description = view.findViewById(R.id.list_description);
            image = view.findViewById(R.id.list_image);
        }

        @Override
        public void bindView(@NonNull FeatureListItem item, @NonNull List<Object> payloads) {
            name.setText(item.name);
            description.setText(item.description);
            image.setImageResource(item.image);
        }

        @Override
        public void unbindView(@NonNull FeatureListItem item) {
            name.setText(null);
            description.setText(null);
            image.setImageResource(NULL_IMAGE);
        }
    }
}
