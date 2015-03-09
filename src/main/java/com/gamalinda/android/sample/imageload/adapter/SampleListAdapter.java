package com.gamalinda.android.sample.imageload.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gamalinda.android.sample.imageload.model.Photo;
import com.gamalinda.android.sample.imageload.viewgroup.PhotoItemViewGroup;
import com.gamalinda.android.sample.imageload.viewgroup.PhotoItemViewGroup_;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class SampleListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    private List<Photo> photos = new ArrayList<Photo>();

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Photo getItem(int i) {
        return photos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return photos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PhotoItemViewGroup photoItemViewGroup;

        if (view == null) {
            photoItemViewGroup = PhotoItemViewGroup_.build(context);
        } else {
            photoItemViewGroup = (PhotoItemViewGroup) view;
        }

        photoItemViewGroup.bind(getItem(i));

        return photoItemViewGroup;
    }
}
