package com.bumptech.glide4.load.engine;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import android.os.Looper;
import com.bumptech.glide4.tests.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 18)
public class ResourceRecyclerTest {

  private ResourceRecycler recycler;

  @Before
  public void setUp() {
    recycler = new ResourceRecycler();
  }

  @Test
  public void testRecyclesResourceSynchronouslyIfNotAlreadyRecyclingResource() {
    Resource<?> resource = Util.mockResource();
    Shadows.shadowOf(Looper.getMainLooper()).pause();
    recycler.recycle(resource);
    verify(resource).recycle();
  }

  @Test
  public void testDoesNotRecycleChildResourceSynchronously() {
    Resource<?> parent = Util.mockResource();
    final Resource<?> child = Util.mockResource();
    doAnswer(new Answer<Void>() {
      @Override
      public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
        recycler.recycle(child);
        return null;
      }
    }).when(parent).recycle();

    Shadows.shadowOf(Looper.getMainLooper()).pause();

    recycler.recycle(parent);

    verify(parent).recycle();
    verify(child, never()).recycle();

    Shadows.shadowOf(Looper.getMainLooper()).runOneTask();

    verify(child).recycle();
  }
}
