package com.bumptech.glide4.load.engine.cache;

import android.content.Context;
import com.bumptech.glide4.disklrucache.DiskLruCache;

import java.io.File;

/**
 * Creates an {@link DiskLruCache} based disk cache in the external
 * disk cache directory.
 *
 * <p><b>Images can be read by everyone when using external disk cache.</b>
 *
 * @deprecated use {@link ExternalPreferredCacheDiskCacheFactory} instead.
 */
// Public API.
@SuppressWarnings({"unused", "WeakerAccess"})
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

  public ExternalCacheDiskCacheFactory(Context context) {
    this(context, DEFAULT_DISK_CACHE_DIR,
            DEFAULT_DISK_CACHE_SIZE);
  }

  public ExternalCacheDiskCacheFactory(Context context, int diskCacheSize) {
    this(context, DEFAULT_DISK_CACHE_DIR, diskCacheSize);
  }

  public ExternalCacheDiskCacheFactory(final Context context, final String diskCacheName,
      int diskCacheSize) {
    super(new CacheDirectoryGetter() {
      @Override
      public File getCacheDirectory() {
        File cacheDirectory = context.getExternalCacheDir();
        if (cacheDirectory == null) {
          return null;
        }
        if (diskCacheName != null) {
          return new File(cacheDirectory, diskCacheName);
        }
        return cacheDirectory;
      }
    }, diskCacheSize);
  }
}
