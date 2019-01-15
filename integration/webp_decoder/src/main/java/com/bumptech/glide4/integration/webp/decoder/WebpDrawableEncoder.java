package com.bumptech.glide4.integration.webp.decoder;

import android.util.Log;

import com.bumptech.glide4.load.EncodeStrategy;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceEncoder;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.util.ByteBufferUtil;

import java.io.File;
import java.io.IOException;

/**
 * Writes the original bytes of a {@link com.bumptech.glide4.integration.webp.decoder.WebpDrawable} to an
 * {@link java.io.OutputStream}.
 *
 * @author liuchun
 */
public class WebpDrawableEncoder implements ResourceEncoder<WebpDrawable> {
    private static final String TAG = "WebpEncoder";

    @Override
    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.SOURCE;
    }

    @Override
    public boolean encode(Resource<WebpDrawable> data, File file, Options options) {
        WebpDrawable drawable = data.get();
        boolean success = false;
        try {
            ByteBufferUtil.toFile(drawable.getBuffer(), file);
            success = true;
        } catch (IOException e) {
            if (Log.isLoggable(TAG, Log.WARN)) {
                Log.w(TAG, "Failed to encode WebP drawable data", e);
            }
        }
        return success;
    }
}
