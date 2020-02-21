package com.folen.androidshowreel.util.listItems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.model.Feature;
import com.folen.androidshowreel.util.manager.ImageManager;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

import static com.folen.androidshowreel.util.Const.ZERO;

public class FeatureListItem extends AbstractItem<FeatureListItem, FeatureListItem.ViewHolder> {

    private Feature feature;

    public FeatureListItem(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }

    @Override
    public int getType() {
        return R.id.item_feature;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_feature;
    }

    @Override
    @NonNull
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<FeatureListItem> {

        private Context context;

        private AppCompatTextView name, description;
        private ImageView image;

        ViewHolder(View view) {
            super(view);

            context = view.getContext();
            name = view.findViewById(R.id.list_name);
            description = view.findViewById(R.id.list_description);
            image = view.findViewById(R.id.list_image);
        }

        @Override
        public void bindView(@NonNull FeatureListItem item, @NonNull List<Object> payloads) {
            name.setText(item.feature.getName());
            description.setText(item.feature.getDescription());
            ImageManager.setupImageWithUrl(context, image, item.feature.getImageUrl());
        }

        @Override
        public void unbindView(@NonNull FeatureListItem item) {
            name.setText(null);
            description.setText(null);
            image.setImageResource(ZERO);
        }
    }
}
