package com.bumptech.glide4.integration.webp.decoder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.load.engine.bitmap_recycle.ArrayPool;

import java.io.IOException;
import java.io.InputStream;

/**
 * Decodes Webp {@link android.graphics.Bitmap Bitmaps} from {@link java.io.InputStream InputStreams}.
 * For static lossless and transparent webp
 *
 * @author liuchun
 */
public class StreamBitmapWebpDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final WebpDownsampler downsampler;
    private final ArrayPool byteArrayPool;

    public StreamBitmapWebpDecoder(WebpDownsampler downsampler, ArrayPool byteArrayPool) {
        this.downsampler = downsampler;
        this.byteArrayPool = byteArrayPool;
    }

    @Override
    public boolean handles(@NonNull InputStream source, @NonNull Options options) throws IOException {
        return downsampler.handles(source, options);
    }

    @Override
    public Resource<Bitmap> decode(@NonNull InputStream source, int width, int height, @NonNull Options options) throws IOException {
        return downsampler.decode(source, width, height, options);
    }
}
