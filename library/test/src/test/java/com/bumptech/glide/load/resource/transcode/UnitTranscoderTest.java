package com.bumptech.glide4.load.resource.transcode;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.bumptech.glide.tests.Util.mockResource;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class UnitTranscoderTest {

  @Test
  public void testReturnsTheGivenResource() {
    Resource<Object> resource = mockResource();
    ResourceTranscoder<Object, Object> unitTranscoder = UnitTranscoder.get();

    assertEquals(resource, unitTranscoder.transcode(resource, new Options()));
  }
}
