package com.bumptech.glide4.load.resource.file;

import static org.junit.Assert.assertEquals;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.load.resource.file.FileDecoder;
import com.bumptech.glide4.util.Preconditions;
import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FileDecoderTest {

  private FileDecoder decoder;
  private Options options;

  @Before
  public void setUp() {
    decoder = new FileDecoder();
    options = new Options();
  }

  @Test
  public void testReturnsGivenFileAsResource() throws IOException {
    File expected = new File("testFile");
    Resource<File> decoded = Preconditions.checkNotNull(decoder.decode(expected, 1, 1, options));

    assertEquals(expected, decoded.get());
  }
}
