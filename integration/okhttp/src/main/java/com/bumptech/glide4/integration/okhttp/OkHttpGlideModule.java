package com.bumptech.glide4.integration.okhttp;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.GlideBuilder;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.load.model.GlideUrl;
import com.bumptech.glide4.load.model.ModelLoader;
import com.bumptech.glide4.module.Glide4Module;

import java.io.InputStream;

/**
 * A {@link Glide4Module} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link ModelLoader}
 * with an OkHttp based {@link ModelLoader}.
 *
 * <p> If you're using gradle, you can include this module simply by depending on the aar, the
 * module will be merged in by manifest merger. For other build systems or for more more
 * information, see {@link Glide4Module}. </p>
 *
 * @deprecated replaced with com.bumptech.glide4.integration.okhttp3.OkHttpGlideModule.
 */
@Deprecated
public class OkHttpGlideModule implements Glide4Module {
  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    // Do nothing.
  }

  @Override
  public void registerComponents(Context context, Glide glide, Registry registry) {
    registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory());
  }
}
