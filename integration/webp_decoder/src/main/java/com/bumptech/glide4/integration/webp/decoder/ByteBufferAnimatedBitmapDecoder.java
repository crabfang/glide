package com.bumptech.glide4.integration.webp.decoder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;
import com.bumptech.glide4.load.engine.Resource;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Decodes webp {@link android.graphics.Bitmap Bitmaps} from {@link java.nio.ByteBuffer ByteBuffers}.
 * For Animated Webp Images
 *
 * @author liuchun
 */
public class ByteBufferAnimatedBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public ByteBufferAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder bitmapDecoder) {
        this.bitmapDecoder = bitmapDecoder;
    }

    @Override
    public boolean handles(@NonNull ByteBuffer source, @NonNull Options options) throws IOException {
        return bitmapDecoder.handles(source, options);
    }

    @Nullable
    @Override
    public Resource<Bitmap> decode(@NonNull ByteBuffer source, int width, int height, @NonNull Options options) throws IOException {
        return bitmapDecoder.decode(source, width, height, options);
    }
}
