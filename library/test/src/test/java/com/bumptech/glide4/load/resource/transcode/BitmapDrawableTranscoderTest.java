package com.bumptech.glide4.load.resource.transcode;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.tests.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 18)
public class BitmapDrawableTranscoderTest {
  private BitmapDrawableTranscoder transcoder;

  @Before
  public void setUp() {
    transcoder = new BitmapDrawableTranscoder(RuntimeEnvironment.application.getResources());
  }

  @Test
  public void testReturnsBitmapDrawableResourceContainingGivenBitmap() {
    Bitmap expected = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    Resource<Bitmap> resource = Util.mockResource();
    when(resource.get()).thenReturn(expected);

    Resource<BitmapDrawable> transcoded = transcoder.transcode(resource, new Options());

    assertEquals(expected, transcoded.get().getBitmap());
  }
}
