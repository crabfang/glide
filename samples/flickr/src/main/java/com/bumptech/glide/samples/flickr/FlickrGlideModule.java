package com.bumptech.glide.samples.flickr;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.GlideBuilder;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide4.load.DecodeFormat;
import com.bumptech.glide4.module.AppGlideModule;
import com.bumptech.glide4.request.RequestOptions;
import com.bumptech.glide.samples.flickr.api.Photo;
import java.io.InputStream;

/**
 * Register {@link FlickrModelLoader} for the Flickr sample app.
 */
@GlideModule
public class FlickrGlideModule extends AppGlideModule {

  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    super.applyOptions(context, builder);
    builder.setDefaultRequestOptions(new RequestOptions().format(DecodeFormat.PREFER_ARGB_8888));
  }

  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    registry.append(Photo.class, InputStream.class, new FlickrModelLoader.Factory());
  }

  // Disable manifest parsing to avoid adding similar modules twice.
  @Override
  public boolean isManifestParsingEnabled() {
    return false;
  }
}
