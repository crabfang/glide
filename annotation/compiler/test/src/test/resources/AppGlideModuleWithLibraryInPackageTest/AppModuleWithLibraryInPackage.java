package com.bumptech.glide4.test;

import com.bumptech.glide4.annotation.Excludes;
import com.bumptech.glide4.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide4.test._package.LibraryModuleInPackage;

@GlideModule
@Excludes(LibraryModuleInPackage.class)
public final class AppModuleWithLibraryInPackage extends AppGlideModule {}
