package com.bumptech.glide4.test;

import android.content.Context;
import android.support.annotation.NonNull;
import androidx.test.InstrumentationRegistry;
import com.bumptech.glide4.Glide;
import com.bumptech.glide4.Priority;
import com.bumptech.glide4.load.DataSource;
import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.data.DataFetcher;
import com.bumptech.glide4.load.model.ModelLoader;
import com.bumptech.glide4.load.model.ModelLoaderFactory;
import com.bumptech.glide4.load.model.MultiModelLoaderFactory;
import com.bumptech.glide4.signature.ObjectKey;

public final class MockModelLoader<ModelT, DataT> implements ModelLoader<ModelT, DataT> {
  private final ModelT model;
  private final DataT data;

  @SuppressWarnings("unchecked")
  public static <ModelT, DataT> void mock(final ModelT model, final DataT data) {
    Context context = InstrumentationRegistry.getTargetContext();

    Glide.get(context)
        .getRegistry()
        .replace(
            (Class<ModelT>) model.getClass(),
            (Class<DataT>) data.getClass(),
            new ModelLoaderFactory<ModelT, DataT>() {
              @NonNull
              @Override
              public ModelLoader<ModelT, DataT> build(
                  @NonNull MultiModelLoaderFactory multiFactory) {
                return new MockModelLoader<>(model, data);
              }

              @Override
              public void teardown() {
                // Do nothing.
              }
            });
  }

  private MockModelLoader(ModelT model, DataT data) {
    this.model = model;
    this.data = data;
  }

  @Override
  public LoadData<DataT> buildLoadData(@NonNull ModelT modelT, int width, int height,
      @NonNull Options options) {
    return new LoadData<>(new ObjectKey(modelT), new MockDataFetcher<>(data));
  }

  @Override
  public boolean handles(@NonNull ModelT model) {
    return this.model.equals(model);
  }

  private static final class MockDataFetcher<DataT> implements DataFetcher<DataT> {

    private final DataT data;

    MockDataFetcher(DataT data) {
      this.data = data;
    }

    @Override
    public void loadData(
        @NonNull Priority priority, @NonNull DataCallback<? super DataT> callback) {
      callback.onDataReady(data);
    }

    @Override
    public void cleanup() {
      // Do nothing.
    }

    @Override
    public void cancel() {
      // Do nothing.
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public Class<DataT> getDataClass() {
      return (Class<DataT>) data.getClass();
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
      return DataSource.REMOTE;
    }
  }
}
