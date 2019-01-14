package com.bumptech.glide.load.resource.transcode;

import static com.bumptech.glide.tests.Util.mockResource;
import static org.junit.Assert.assertEquals;

import com.bumptech.glide4.load.Options;
import com.bumptech.glide4.load.engine.Resource;
import com.bumptech.glide4.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide4.load.resource.transcode.UnitTranscoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UnitTranscoderTest {

  @Test
  public void testReturnsTheGivenResource() {
    Resource<Object> resource = mockResource();
    ResourceTranscoder<Object, Object> unitTranscoder = UnitTranscoder.get();

    assertEquals(resource, unitTranscoder.transcode(resource, new Options()));
  }
}
