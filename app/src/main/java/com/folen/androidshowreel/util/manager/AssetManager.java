package com.folen.androidshowreel.util.manager;

import android.content.Context;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

import static com.folen.androidshowreel.util.Const.DEFAULT_CHARSET;

public class AssetManager {

    @Nullable
    public static String loadJsonFromAssets(Context context, String name) {
        String result;
        try {
            InputStream is = context.getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result = new String(buffer, DEFAULT_CHARSET);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }
}
