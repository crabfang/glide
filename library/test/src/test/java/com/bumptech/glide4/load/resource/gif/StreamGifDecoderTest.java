package com.bumptech.glide4.load.resource.gif;

import static com.google.common.truth.Truth.assertThat;

import com.bumptech.glide4.load.ImageHeaderParser;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.ResourceDecoder;
import com.bumptech.glide4.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide4.load.resource.bitmap.DefaultImageHeaderParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide4.load.resource.gif.GifDrawable;
import com.bumptech.glide4.load.resource.gif.GifOptions;
import com.bumptech.glide4.load.resource.gif.StreamGifDecoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 18)
public class StreamGifDecoderTest {
  private static final byte[] GIF_HEADER = new byte[] { 0x47, 0x49, 0x46 };

  @Mock private ResourceDecoder<ByteBuffer, GifDrawable> byteBufferDecoder;
  private StreamGifDecoder decoder;
  private Options options;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    List<ImageHeaderParser> parsers = new ArrayList<>();
    parsers.add(new DefaultImageHeaderParser());

    decoder = new StreamGifDecoder(parsers, byteBufferDecoder, new LruArrayPool());
    options = new Options();
  }

  @Test
  public void testDoesNotHandleStreamIfEnabledButNotAGif() throws IOException {
    assertThat(decoder.handles(new ByteArrayInputStream(new byte[0]), options)).isFalse();
  }

  @Test
  public void testHandlesStreamIfContainsGifHeaderAndDisabledIsNotSet() throws IOException {
    assertThat(decoder.handles(new ByteArrayInputStream(GIF_HEADER), options)).isTrue();
  }

  @Test
  public void testHandlesStreamIfContainsGifHeaderAndDisabledIsFalse() throws IOException {
    options.set(GifOptions.DISABLE_ANIMATION, false);
    assertThat(decoder.handles(new ByteArrayInputStream(GIF_HEADER), options)).isTrue();
  }

  @Test
  public void testDoesNotHandleStreamIfDisabled() throws IOException {
    options.set(GifOptions.DISABLE_ANIMATION, true);
    assertThat(decoder.handles(new ByteArrayInputStream(GIF_HEADER), options)).isFalse();
  }
}
