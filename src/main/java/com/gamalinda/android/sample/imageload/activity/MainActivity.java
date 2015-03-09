package com.gamalinda.android.sample.imageload.activity;

import android.app.Activity;
import android.widget.ListView;
import com.gamalinda.android.sample.imageload.R;
import com.gamalinda.android.sample.imageload.adapter.SampleListAdapter;
import com.gamalinda.android.sample.imageload.model.Photo;
import com.gamalinda.android.sample.imageload.service.RestMethod;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.main)
public class MainActivity extends Activity {
    @RestService
    RestMethod restMethod;

    List<Photo> photos = new ArrayList<Photo>();

    @Bean
    SampleListAdapter adapter;

    @ViewById(R.id.list_view)
    ListView listView;

    @AfterViews
    void afterViews() {
        adapter.setPhotos(photos);
        listView.setAdapter(adapter);
        getPhotos();
    }

    @Background
    void getPhotos() {
        photos = restMethod.getPhotos();
        reloadList();
    }

    @UiThread
    void reloadList() {
        adapter.setPhotos(photos);
        adapter.notifyDataSetChanged();
    }
}
