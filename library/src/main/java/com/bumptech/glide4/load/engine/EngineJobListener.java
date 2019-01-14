package com.bumptech.glide4.load.engine;

import com.bumptech.glide4.load.Key;

interface EngineJobListener {

  void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> resource);

  void onEngineJobCancelled(EngineJob<?> engineJob, Key key);
}
