package com.bumptech.glide4.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide4.load.ResourceDecoder;

/**
 * An {@link ResourceDecoder} that can decode a thumbnail frame
 * {@link android.graphics.Bitmap} from a {@link android.os.ParcelFileDescriptor} containing a
 * video.
 *
 * @see android.media.MediaMetadataRetriever
 *
 * @deprecated Use {@link VideoDecoder#parcel(BitmapPool)} instead. This class may be removed and
 * {@link VideoDecoder} may become final in a future version of Glide.
 */
@Deprecated
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {

  @SuppressWarnings("unused")
  public VideoBitmapDecoder(Context context) {
    this(Glide.get(context).getBitmapPool());
  }

  // Public API
  @SuppressWarnings("WeakerAccess")
  public VideoBitmapDecoder(BitmapPool bitmapPool) {
    super(bitmapPool, new ParcelFileDescriptorInitializer());
  }
}
