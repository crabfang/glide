package com.bumptech.glide4.request.target;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.bumptech.glide4.RequestManager;
import com.bumptech.glide4.request.Request;
import com.bumptech.glide4.request.target.PreloadTarget;
import com.bumptech.glide4.request.target.SizeReadyCallback;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 18)
public class PreloadTargetTest {

  @Mock private RequestManager requestManager;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCallsSizeReadyWithGivenDimensions() {
    int width = 1234;
    int height = 456;
    PreloadTarget<Object> target = PreloadTarget.obtain(requestManager, width, height);
    SizeReadyCallback cb = mock(SizeReadyCallback.class);
    target.getSize(cb);

    verify(cb).onSizeReady(eq(width), eq(height));
  }

  @Test
  public void testClearsTargetInOnResourceReady() {
    Request request = mock(Request.class);
    PreloadTarget<Object> target = PreloadTarget.obtain(requestManager, 100, 100);
    target.setRequest(request);
    target.onResourceReady(new Object(), null);

    verify(requestManager).clear(eq(target));
  }
}
