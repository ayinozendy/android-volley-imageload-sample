package com.gamalinda.android.sample.imageload.viewgroup;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;
import com.gamalinda.android.sample.imageload.R;
import com.gamalinda.android.sample.imageload.helper.VolleyImageHelper;
import com.gamalinda.android.sample.imageload.model.Photo;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_photo_item)
public class PhotoItemViewGroup extends LinearLayout {

    @ViewById(R.id.thumbnail)
    NetworkImageView imageView;

    @ViewById(R.id.album_id)
    TextView albumId;

    @ViewById(R.id.photo_id)
    TextView photoId;

    @ViewById(R.id.title)
    TextView title;

    public PhotoItemViewGroup(Context context) {
        super(context);
    }

    public void bind(Photo photo) {
        imageView.setImageUrl(photo.getThumbnailUrl(), VolleyImageHelper.getInstance().getImageLoader());
        albumId.setText(Long.toString(photo.getAlbumId()));
        photoId.setText(Long.toString(photo.getId()));
        title.setText(photo.getTitle());
    }
}
