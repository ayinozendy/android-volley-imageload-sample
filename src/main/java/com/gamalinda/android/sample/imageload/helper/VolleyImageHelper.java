package com.gamalinda.android.sample.imageload.helper;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.gamalinda.android.sample.imageload.Main;

public class VolleyImageHelper {
    private static VolleyImageHelper mInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleyImageHelper() {
        mRequestQueue = Volley.newRequestQueue(Main.getAppContext());
        mImageLoader = new ImageLoader(this.mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }

            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
    }

    public static VolleyImageHelper getInstance() {
        if (mInstance == null) {
            mInstance = new VolleyImageHelper();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return this.mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return this.mImageLoader;
    }
}
