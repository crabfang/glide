package com.bumptech.glide.samples.flickr;

import android.support.annotation.NonNull;
import com.bumptech.glide4.annotation.GlideExtension;
import com.bumptech.glide4.annotation.GlideOption;
import com.bumptech.glide4.request.BaseRequestOptions;
import com.bumptech.glide.samples.flickr.api.Api;

/**
 * Extension methods for the Flickr sample's generated API.
 */
// Required by Glide's annotation processor.
@SuppressWarnings({"WeakerAccess", "unused"})
@GlideExtension
public final class FlickrGlideExtension {

  private FlickrGlideExtension() {
    // Utility class.
  }

  @NonNull
  @GlideOption
  public static BaseRequestOptions<?> squareThumb(BaseRequestOptions<?> requestOptions) {
    return requestOptions.centerCrop();
  }

  @NonNull
  @GlideOption
  public static BaseRequestOptions<?> squareMiniThumb(BaseRequestOptions<?> requestOptions) {
    return requestOptions.centerCrop().override(Api.SQUARE_THUMB_SIZE);
  }
}
