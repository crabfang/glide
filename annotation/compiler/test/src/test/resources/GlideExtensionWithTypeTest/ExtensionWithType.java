package com.bumptech.glide.test;

import android.support.annotation.NonNull;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide4.annotation.GlideExtension;
import com.bumptech.glide4.annotation.GlideType;

@GlideExtension
public final class ExtensionWithType {

  private ExtensionWithType() {
    // Utility class.
  }

  @NonNull
  @GlideType(Number.class)
  public static RequestBuilder<Number> asNumber(RequestBuilder<Number> builder) {
    return builder;
  }
}
