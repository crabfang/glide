package com.bumptech.glide4.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide4.annotation.GlideExtension;

import java.io.File;
import java.lang.Deprecated;
import java.lang.String;

/**
 * The entry point for interacting with Glide for Applications
 *
 * <p>Includes all generated APIs from all
 * {@link GlideExtension}s in source and dependent libraries.
 *
 * <p>This class is generated and should not be modified
 * @see Glide
 */
public final class GlideApp {
  private GlideApp() {
  }

  /**
   * @see Glide#getPhotoCacheDir(Context)
   */
  @Nullable
  public static File getPhotoCacheDir(@NonNull Context context) {
    return Glide.getPhotoCacheDir(context);
  }

  /**
   * @see Glide#getPhotoCacheDir(Context, String)
   */
  @Nullable
  public static File getPhotoCacheDir(@NonNull Context context, @NonNull String string) {
    return Glide.getPhotoCacheDir(context, string);
  }

  /**
   * @see Glide#get(Context)
   */
  @NonNull
  public static Glide get(@NonNull Context context) {
    return Glide.get(context);
  }

  /**
   * @see Glide#init(Glide)
   */
  @Deprecated
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void init(Glide glide) {
    Glide.init(glide);
  }

  /**
   * @see Glide#init(Context, GlideBuilder)
   */
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void init(@NonNull Context context, @NonNull GlideBuilder builder) {
    Glide.init(context, builder);
  }

  /**
   * @see Glide#tearDown()
   */
  @VisibleForTesting
  @SuppressLint("VisibleForTests")
  public static void tearDown() {
    Glide.tearDown();
  }

  /**
   * @see Glide#with(Context)
   */
  @NonNull
  public static GlideRequests with(@NonNull Context context) {
    return (GlideRequests) Glide.with(context);
  }

  /**
   * @see Glide#with(Activity)
   */
  @NonNull
  public static GlideRequests with(@NonNull Activity activity) {
    return (GlideRequests) Glide.with(activity);
  }

  /**
   * @see Glide#with(FragmentActivity)
   */
  @NonNull
  public static GlideRequests with(@NonNull FragmentActivity activity) {
    return (GlideRequests) Glide.with(activity);
  }

  /**
   * @see Glide#with(Fragment)
   */
  @NonNull
  public static GlideRequests with(@NonNull Fragment fragment) {
    return (GlideRequests) Glide.with(fragment);
  }

  /**
   * @see Glide#with(Fragment)
   */
  @Deprecated
  @NonNull
  public static GlideRequests with(@NonNull android.app.Fragment fragment) {
    return (GlideRequests) Glide.with(fragment);
  }

  /**
   * @see Glide#with(View)
   */
  @NonNull
  public static GlideRequests with(@NonNull View view) {
    return (GlideRequests) Glide.with(view);
  }
}
