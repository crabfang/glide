package com.bumptech.glide4.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;
import com.bumptech.glide4.load.engine.Resource;

/**
 * Passes through a {@link Drawable} as a {@link Drawable} based {@link Resource}.
 */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
  @Override
  public boolean handles(@NonNull Drawable source, @NonNull Options options) {
    return true;
  }

  @Nullable
  @Override
  public Resource<Drawable> decode(@NonNull Drawable source, int width, int height,
      @NonNull Options options) {
    return NonOwnedDrawableResource.newInstance(source);
  }
}
