package com.bumptech.glide4;

import static com.google.common.truth.Truth.assertThat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import androidx.test.InstrumentationRegistry;
import com.bumptech.glide4.test.ConcurrencyHelper;
import com.bumptech.glide4.test.GlideApp;
import com.bumptech.glide4.test.GlideRequests;
import com.bumptech.glide4.test.ResourceIds;
import com.bumptech.glide4.test.TearDownGlide;
import com.bumptech.glide4.request.Request;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests how {@link Request}s behave when the corresponding
 * {@link RequestManager} is paused.
 */
public final class PausedRequestsTest {
  @Rule public final TearDownGlide tearDownGlide = new TearDownGlide();
  private final ConcurrencyHelper concurrency = new ConcurrencyHelper();
  private final Context context = InstrumentationRegistry.getTargetContext();

  @SuppressWarnings("unchecked")
  @Test
  public void load_withPlaceHolderSet_requestsPaused_displaysPlaceholder() {
    final ImageView imageView = new ImageView(context);

    final GlideRequests requests = GlideApp.with(context);
    concurrency.runOnMainThread(new Runnable() {
      @Override
      public void run() {
        requests.pauseAllRequests();
      }
    });

    final ColorDrawable expected = new ColorDrawable(Color.RED);
    concurrency.runOnMainThread(
        new Runnable() {
          @Override
          public void run() {
            requests
                .load(ResourceIds.drawable.bitmap_alias)
                .placeholder(expected)
                .into(imageView);
          }
        });

    assertThat(imageView.getDrawable()).isEqualTo(expected);
  }
}
