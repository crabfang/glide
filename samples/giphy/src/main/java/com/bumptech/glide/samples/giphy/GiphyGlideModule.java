package com.bumptech.glide.samples.giphy;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide4.module.AppGlideModule;
import java.io.InputStream;

/**
 * Configures Glide for the Giphy sample app.
 */
@GlideModule
public class GiphyGlideModule extends AppGlideModule {
  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    registry.append(Api.GifResult.class, InputStream.class, new GiphyModelLoader.Factory());
  }

  // Disable manifest parsing to avoid adding similar modules twice.
  @Override
  public boolean isManifestParsingEnabled() {
    return false;
  }
}
