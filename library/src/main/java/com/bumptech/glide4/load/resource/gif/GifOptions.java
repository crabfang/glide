package com.bumptech.glide4.load.resource.gif;

import com.bumptech.glide4.load.DecodeFormat;
import com.bumptech.glide4.load.Option;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;

/**
 * Options related to decoding GIFs.
 */
public final class GifOptions {

  /**
   * Indicates the {@link DecodeFormat} that will be used in conjunction
   * with the particular GIF to determine the {@link android.graphics.Bitmap.Config} to use when
   * decoding frames of GIFs.
   */
  public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory(
      "GifOptions.DecodeFormat", DecodeFormat.DEFAULT);

  /**
   * If set to {@code true}, disables the GIF {@link ResourceDecoder}s
   * ({@link ResourceDecoder#handles(Object, Options)} will return {@code false}). Defaults to
   * {@code false}.
   */
  public static final Option<Boolean> DISABLE_ANIMATION = Option.memory(
      "GifOptions.DisableAnimation", false);

  private GifOptions() {
    // Utility class.
  }
}
