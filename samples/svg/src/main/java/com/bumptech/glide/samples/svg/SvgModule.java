package com.bumptech.glide.samples.svg;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide4.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import java.io.InputStream;

/**
 * Module for the SVG sample app.
 */
@GlideModule
public class SvgModule extends AppGlideModule {
  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
        .append(InputStream.class, SVG.class, new SvgDecoder());
  }

  // Disable manifest parsing to avoid adding similar modules twice.
  @Override
  public boolean isManifestParsingEnabled() {
    return false;
  }
}
