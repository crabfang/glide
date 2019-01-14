package com.bumptech.glide4.module;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.annotation.Excludes;

/**
 * Registers a set of components to use when initializing Glide within an app when
 * Glide's annotation processor is used.
 *
 * <p>Any number of LibraryGlideModules can be contained within any library or application.
 *
 * <p>LibraryGlideModules are called in no defined order. If LibraryGlideModules within an
 * application conflict, {@link AppGlideModule}s can use the
 * {@link Excludes} annotation to selectively remove one or more of
 * the conflicting modules.
 */
@SuppressWarnings("deprecation")
public abstract class LibraryGlideModule implements RegistersComponents {
  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    // Default empty impl.
  }
}
