package com.bumptech.glide4;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide4.GenericTransitionOptions;
import com.bumptech.glide4.GlideContext;
import com.bumptech.glide4.Registry;
import com.bumptech.glide4.TransitionOptions;
import com.bumptech.glide4.load.engine.Engine;
import com.bumptech.glide4.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide4.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide4.load.resource.gif.GifDrawable;
import com.bumptech.glide4.request.RequestListener;
import com.bumptech.glide4.request.RequestOptions;
import com.bumptech.glide4.request.target.ImageViewTargetFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class GlideContextTest {
  private Map<Class<?>, TransitionOptions<?, ?>> transitionOptions;
  private GlideContext context;

  @Before
  public void setUp() {
    Application app = RuntimeEnvironment.application;

    transitionOptions = new HashMap<>();
    context = new GlideContext(
        app,
        new LruArrayPool(),
        new Registry(),
        new ImageViewTargetFactory(),
        new RequestOptions(),
        transitionOptions,
        /*defaultRequestListeners=*/ Collections.<RequestListener<Object>>emptyList(),
        mock(Engine.class),
        /*isLoggingRequestOriginsEnabled=*/ false,
        Log.DEBUG);
  }

  @Test
  public void getDefaultTransitionOptions_withNoOptionsRegistered_returnsDefaultOptions() {
    assertThat(context.getDefaultTransitionOptions(Object.class))
        .isEqualTo(GlideContext.DEFAULT_TRANSITION_OPTIONS);
  }

  @Test
  public void getDefaultTransitionOptions_withNonMatchingOptionRegistered_returnsDefaultOptions() {
    transitionOptions.put(Bitmap.class, new GenericTransitionOptions<>());
    assertThat(context.getDefaultTransitionOptions(Drawable.class))
        .isEqualTo(GlideContext.DEFAULT_TRANSITION_OPTIONS);
  }

  @Test
  public void getDefaultTransitionOptions_withMatchingOptionsRegistered_returnsMatchingOptions() {
    GenericTransitionOptions<Object> expected = new GenericTransitionOptions<>();
    transitionOptions.put(Bitmap.class, expected);
    assertThat(context.getDefaultTransitionOptions(Bitmap.class))
        .isEqualTo(expected);
  }

  @Test
  public void getDefaultTransitionOptions_withSuperClassRegistered_returnsSuperClassOptions() {
    DrawableTransitionOptions expected = new DrawableTransitionOptions();
    transitionOptions.put(Drawable.class, expected);
    assertThat(context.getDefaultTransitionOptions(BitmapDrawable.class))
        .isEqualTo(expected);
    assertThat(context.getDefaultTransitionOptions(GifDrawable.class))
        .isEqualTo(expected);
  }
}
