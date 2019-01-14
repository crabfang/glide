package com.bumptech.glide4.load.engine.cache;

import android.content.Context;
import com.bumptech.glide4.disklrucache.DiskLruCache;

import java.io.File;

/**
 * Creates an {@link DiskLruCache} based disk cache in the internal
 * disk cache directory.
 */
// Public API.
@SuppressWarnings({"WeakerAccess", "unused"})
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

  public InternalCacheDiskCacheFactory(Context context) {
    this(context, DEFAULT_DISK_CACHE_DIR,
            DEFAULT_DISK_CACHE_SIZE);
  }

  public InternalCacheDiskCacheFactory(Context context, long diskCacheSize) {
    this(context, DEFAULT_DISK_CACHE_DIR, diskCacheSize);
  }

  public InternalCacheDiskCacheFactory(final Context context, final String diskCacheName,
                                       long diskCacheSize) {
    super(new CacheDirectoryGetter() {
      @Override
      public File getCacheDirectory() {
        File cacheDirectory = context.getCacheDir();
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
