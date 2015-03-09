##Sample Code for Using Android Volley Image Load

To use Google Volley Image Loading

You need to clone and compile the library from [Google Platform Frameworks](https://android.googlesource.com/platform/frameworks/volley)


```
git clone https://android.googlesource.com/platform/frameworks/volley
```

Then compile the source using Maven, and it will automatically install to your M2 Repository.

```
mvn clean install
```

Now, to use it on your project, you need to add the dependency on your pom.

```
<dependency>
  <groupId>com.android.volley</groupId>
  <artifactId>volley</artifactId>
  <version>${android.volley.version}</version>
  <type>jar</type>
  <exclusions>
    <exclusion>
      <groupId>com.google.android</groupId>
      <artifactId>android</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

###Usage

Instead of using _ImageView_ for on your layout, use **com.android.volley.toolbox.NetworkImageView**.

To set the image from a URL, you can do it like so:

```
NetworkImageView networkImageView = (NetworkImageView)view.findViewById(R.id.twitter_avatar);
networkImageView.setImageUrl("http://example.com/image.png",mImageLoader);
```

> Note you can also inject the View using AndroidAnnotations like your regular Views.

###Setup

You need an instance of _ImageLoader_ to make _NetworkImageView_ work, but that means you have to initialize one everytime you need it.

Google recommends to use a singleton of a _Volley RequestQue and ImageLoader Helper_ object for your Application.

Example: [VolleyImageHelper.java](https://github.com/ayinozendy/android-volley-imageload-sample/blob/master/src/main/java/com/gamalinda/android/sample/imageload/helper/VolleyImageHelper.java)


You also need a static application context to help VolleyImageHelper in finding the _Context_.

Example: [Main.java](https://github.com/ayinozendy/android-volley-imageload-sample/blob/master/src/main/java/com/gamalinda/android/sample/imageload/Main.java)

_Main_ should be declared as the **name** of the _Application_ on your AndroidManifest file.

```
<application android:name=".Main"...>
  ...
</application>
```

Now to get an instance of the ImageLoader, you can just call the VolleyImageHelper like so:

```
mImageLoader = VolleyImageHelper.getInstance().getImageLoader()
```

###Resources

[Android Developer Training on Volley](http://developer.android.com/training/volley/request.html)

[RequestQueue object for Volley](https://github.com/CypressNorth/Volley-Singleton)

[Choosing your Image Loading Library](https://plus.google.com/103583939320326217147/posts/bfAFC5YZ3mq)
