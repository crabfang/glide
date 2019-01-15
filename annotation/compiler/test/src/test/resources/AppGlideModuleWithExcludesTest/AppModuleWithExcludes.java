package com.bumptech.glide4.test;

import com.bumptech.glide4.annotation.Excludes;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
@Excludes(EmptyLibraryModule.class)
public final class AppModuleWithExcludes extends AppGlideModule {}