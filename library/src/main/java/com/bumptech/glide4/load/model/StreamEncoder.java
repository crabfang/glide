package com.bumptech.glide4.load.model;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide4.load.Encoder;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.bitmap_recycle.ArrayPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * An {@link Encoder} that can write an {@link java.io.InputStream} to
 * disk.
 */
public class StreamEncoder implements Encoder<InputStream> {
  private static final String TAG = "StreamEncoder";
  private final ArrayPool byteArrayPool;

  public StreamEncoder(ArrayPool byteArrayPool) {
    this.byteArrayPool = byteArrayPool;
  }

  @Override
  public boolean encode(@NonNull InputStream data, @NonNull File file, @NonNull Options options) {
    byte[] buffer = byteArrayPool.get(ArrayPool.STANDARD_BUFFER_SIZE_BYTES, byte[].class);
    boolean success = false;
    OutputStream os = null;
    try {
      os = new FileOutputStream(file);
      int read;
      while ((read = data.read(buffer)) != -1) {
        os.write(buffer, 0, read);
      }
      os.close();
      success = true;
    } catch (IOException e) {
      if (Log.isLoggable(TAG, Log.DEBUG)) {
        Log.d(TAG, "Failed to encode data onto the OutputStream", e);
      }
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException e) {
          // Do nothing.
        }
      }
      byteArrayPool.put(buffer);
    }
    return success;
  }
}