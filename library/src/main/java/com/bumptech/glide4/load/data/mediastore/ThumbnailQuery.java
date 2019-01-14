package com.bumptech.glide4.load.data.mediastore;

import android.database.Cursor;
import android.net.Uri;

interface ThumbnailQuery {
  Cursor query(Uri uri);
}
