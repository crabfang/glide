package com.bumptech.glide4.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses {@link Glide4Module} references out of the AndroidManifest file.
 */
// Used only in javadoc.
@SuppressWarnings("deprecation")
@Deprecated
public final class ManifestParser {
  private static final String TAG = "ManifestParser";
  private static final String GLIDE_MODULE_VALUE = "Glide4Module";

  private final Context context;

  public ManifestParser(Context context) {
    this.context = context;
  }

  @SuppressWarnings("deprecation")
  public List<Glide4Module> parse() {
    if (Log.isLoggable(TAG, Log.DEBUG)) {
      Log.d(TAG, "Loading Glide modules");
    }
    List<Glide4Module> modules = new ArrayList<>();
    try {
      ApplicationInfo appInfo = context.getPackageManager()
          .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
      if (appInfo.metaData == null) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
          Log.d(TAG, "Got null app info metadata");
        }
        return modules;
      }
      if (Log.isLoggable(TAG, Log.VERBOSE)) {
        Log.v(TAG, "Got app info metadata: " + appInfo.metaData);
      }
      for (String key : appInfo.metaData.keySet()) {
        if (GLIDE_MODULE_VALUE.equals(appInfo.metaData.get(key))) {
          modules.add(parseModule(key));
          if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "Loaded Glide module: " + key);
          }
        }
      }
    } catch (PackageManager.NameNotFoundException e) {
      throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
    }
    if (Log.isLoggable(TAG, Log.DEBUG)) {
      Log.d(TAG, "Finished loading Glide modules");
    }

    return modules;
  }

  @SuppressWarnings("deprecation")
  private static Glide4Module parseModule(String className) {
    Class<?> clazz;
    try {
      clazz = Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("Unable to find Glide4Module implementation", e);
    }

    Object module = null;
    try {
      module = clazz.getDeclaredConstructor().newInstance();
    // These can't be combined until API minimum is 19.
    } catch (InstantiationException e) {
      throwInstantiateGlideModuleException(clazz, e);
    } catch (IllegalAccessException e) {
      throwInstantiateGlideModuleException(clazz, e);
    } catch (NoSuchMethodException e) {
      throwInstantiateGlideModuleException(clazz, e);
    } catch (InvocationTargetException e) {
      throwInstantiateGlideModuleException(clazz, e);
    }

    if (!(module instanceof Glide4Module)) {
      throw new RuntimeException("Expected instanceof Glide4Module, but found: " + module);
    }
    return (Glide4Module) module;
  }

  private static void throwInstantiateGlideModuleException(Class<?> clazz, Exception e) {
    throw new RuntimeException("Unable to instantiate Glide4Module implementation for " + clazz, e);
  }
}
