package com.bumptech.glide4.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide4.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide4.util.Preconditions;

/**
 * An {@link ResourceTranscoder} that converts {@link
 * android.graphics.Bitmap}s into {@link android.graphics.drawable.BitmapDrawable}s.
 */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
  private final Resources resources;

  // Public API.
  @SuppressWarnings("unused")
  public BitmapDrawableTranscoder(@NonNull Context context) {
    this(context.getResources());
  }

  /**
   * @deprecated Use {@link #BitmapDrawableTranscoder(Resources)}, {@code bitmapPool} is unused.
   */
  @Deprecated
  public BitmapDrawableTranscoder(
      @NonNull Resources resources, @SuppressWarnings("unused") BitmapPool bitmapPool) {
    this(resources);
  }

  public BitmapDrawableTranscoder(@NonNull Resources resources) {
    this.resources = Preconditions.checkNotNull(resources);
  }

  @Nullable
  @Override
  public Resource<BitmapDrawable> transcode(@NonNull Resource<Bitmap> toTranscode,
      @NonNull Options options) {
    return LazyBitmapDrawableResource.obtain(resources, toTranscode);
  }
}
