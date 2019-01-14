package com.bumptech.glide4.load.resource.file;

import android.support.annotation.NonNull;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;
import com.bumptech.glide4.load.engine.Resource;

import java.io.File;

/**
 * A simple {@link ResourceDecoder} that creates resource for a given {@link
 * java.io.File}.
 */
public class FileDecoder implements ResourceDecoder<File, File> {

  @Override
  public boolean handles(@NonNull File source, @NonNull Options options) {
    return true;
  }

  @Override
  public Resource<File> decode(@NonNull File source, int width, int height,
                               @NonNull Options options) {
    return new FileResource(source);
  }
}
