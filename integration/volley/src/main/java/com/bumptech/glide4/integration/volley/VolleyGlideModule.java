package com.bumptech.glide4.integration.volley;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.GlideBuilder;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.load.model.GlideUrl;
import com.bumptech.glide4.load.model.ModelLoader;
import com.bumptech.glide4.module.GlideModule;

import java.io.InputStream;

/**
 * A {@link GlideModule} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link ModelLoader} with a
 * Volley based {@link ModelLoader}.
 *
 * <p> If you're using gradle, you can include this module simply by depending on the aar, the
 * module will be merged in by manifest merger. For other build systems or for more more
 * information, see {@link GlideModule}.
 *
 * @deprecated Replaced with {@link VolleyLibraryGlideModule}.
 */
@Deprecated
@SuppressWarnings("deprecation")
public class VolleyGlideModule implements GlideModule {
  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    // Do nothing.
  }

  @Override
  public void registerComponents(Context context, Glide glide, Registry registry) {
    registry.replace(GlideUrl.class, InputStream.class, new VolleyUrlLoader.Factory(context));
  }
}
