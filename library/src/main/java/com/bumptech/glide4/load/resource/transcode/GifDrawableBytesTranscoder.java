package com.bumptech.glide4.load.resource.transcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.load.resource.bytes.BytesResource;
import com.bumptech.glide4.load.resource.gif.GifDrawable;
import com.bumptech.glide4.util.ByteBufferUtil;

import java.nio.ByteBuffer;

/**
 * An {@link ResourceTranscoder} that converts {@link
 * GifDrawable} into bytes by obtaining the original bytes of
 * the GIF from the {@link GifDrawable}.
 */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
  @Nullable
  @Override
  public Resource<byte[]> transcode(@NonNull Resource<GifDrawable> toTranscode,
                                    @NonNull Options options) {
    GifDrawable gifData = toTranscode.get();
    ByteBuffer byteBuffer = gifData.getBuffer();
    return new BytesResource(ByteBufferUtil.toBytes(byteBuffer));
  }
}