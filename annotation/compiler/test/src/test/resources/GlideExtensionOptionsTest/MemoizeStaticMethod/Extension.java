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
  @GlideOption(memoizeStaticMethod = true)
  public static BaseRequestOptions<?> test(BaseRequestOptions<?> requestOptions) {
    return requestOptions.centerCrop();
  }
}
