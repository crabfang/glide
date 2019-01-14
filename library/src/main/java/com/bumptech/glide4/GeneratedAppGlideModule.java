package com.bumptech.glide4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide4.manager.RequestManagerRetriever;
import com.bumptech.glide4.module.AppGlideModule;
import java.util.Set;

/**
 * Allows {@link AppGlideModule}s to exclude {@link GlideModule}s to
 * ease the migration from {@link GlideModule}s to Glide's annotation
 * processing system and optionally provides a
 * {@link RequestManagerRetriever.RequestManagerFactory} impl.
 */
abstract class GeneratedAppGlideModule extends AppGlideModule {
  /**
   * This method can be removed when manifest parsing is no longer supported.
   */
  @NonNull
  abstract Set<Class<?>> getExcludedModuleClasses();

  @Nullable
  RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
    return null;
  }
}
