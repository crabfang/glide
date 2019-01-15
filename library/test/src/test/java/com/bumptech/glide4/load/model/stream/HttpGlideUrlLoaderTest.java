package com.bumptech.glide4.load.model.stream;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.data.DataFetcher;
import com.bumptech.glide4.load.data.HttpUrlFetcher;
import com.bumptech.glide4.load.model.GlideUrl;
import com.bumptech.glide4.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide4.util.Preconditions;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class HttpGlideUrlLoaderTest {
  private HttpGlideUrlLoader loader;
  private GlideUrl model;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    loader = new HttpGlideUrlLoader();
    model = mock(GlideUrl.class);
  }

  @Test
  public void testReturnsValidFetcher() {
    DataFetcher<InputStream> result =
        Preconditions.checkNotNull(loader.buildLoadData(model, 100, 100, new Options())).fetcher;
    assertThat(result).isInstanceOf(HttpUrlFetcher.class);
  }
}
