package com.bumptech.glide.test;

import android.support.annotation.NonNull;
import com.bumptech.glide4.annotation.GlideExtension;
import com.bumptech.glide4.annotation.GlideOption;
import com.bumptech.glide.request.BaseRequestOptions;

@GlideExtension
public final class Extension {

  private Extension() {
    // Utility class.
  }

  @NonNull
  @GlideOption(override = GlideOption.OVERRIDE_EXTEND)
  public static BaseRequestOptions<?> override(BaseRequestOptions<?> requestOptions, int width, int height) {
    return requestOptions
        .override(width, height)
        .centerCrop();
  }
}
