package com.bumptech.glide.integration.volley;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide4.load.model.GlideUrl;
import com.bumptech.glide4.module.AppGlideModule;
import com.bumptech.glide4.module.LibraryGlideModule;
import com.bumptech.glide4.load.model.ModelLoader;

import java.io.InputStream;

/**
 * A {@link com.bumptech.glide4.module.GlideModule} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link ModelLoader} with a
 * Volley based {@link ModelLoader}.
 *
 * <p>For Applications that depend on this library and include an
 * {@link AppGlideModule} and Glide's annotation processor, this class
 * will be automatically included.
 */
@GlideModule
public class VolleyLibraryGlideModule extends LibraryGlideModule {
  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    registry.replace(GlideUrl.class, InputStream.class, new VolleyUrlLoader.Factory(context));
  }
}
