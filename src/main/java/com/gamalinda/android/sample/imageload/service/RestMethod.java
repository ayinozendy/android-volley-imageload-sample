package com.gamalinda.android.sample.imageload.service;

import com.gamalinda.android.sample.imageload.model.Photo;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Rest(rootUrl = "http://jsonplaceholder.typicode.com/", converters ={MappingJackson2HttpMessageConverter.class})
public interface RestMethod {

    @Get("photos/")
    List<Photo> getPhotos();
}
