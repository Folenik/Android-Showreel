package com.folen.androidshowreel.util;

import static com.folen.androidshowreel.util.Const.FEATURE_REALIZATION_ALL;
import static com.folen.androidshowreel.util.Const.FEATURE_REALIZATION_DONE;
import static com.folen.androidshowreel.util.Const.FEATURE_REALIZATION_TODO;

public enum FeatureRealization {

    ALL(FEATURE_REALIZATION_ALL),
    DONE(FEATURE_REALIZATION_DONE),
    TODO(FEATURE_REALIZATION_TODO);

    private final String type;

    FeatureRealization(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

