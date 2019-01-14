package com.bumptech.glide.test;

import android.support.annotation.NonNull;
import com.bumptech.glide4.annotation.GlideExtension;
import com.bumptech.glide4.annotation.GlideOption;
import com.bumptech.glide.request.BaseRequestOptions;

@GlideExtension
public final class ExtensionWithOption {

  private ExtensionWithOption() {
    // Utility class.
  }

  @NonNull
  @GlideOption
  public static BaseRequestOptions<?> squareThumb(BaseRequestOptions<?> requestOptions) {
    return requestOptions.centerCrop();
  }
}
