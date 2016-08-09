package com.equationsolver.kolek.krzysztof.equationsolver;

import android.graphics.Bitmap;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import ImageProcessing.ImageLoader;

public class ImageLoaderUnitTest  {

    private ImageLoader _loader = null;

    public ImageLoaderUnitTest() {
        _loader = new ImageLoader();
    }

    @Test
    public void loadsTheImageShdouldBeNotNull() {
       // ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource("sum.jpg").getFile());

        Bitmap loadedImage = _loader.loadImage("sum.jpg", true);
        assertNotNull(loadedImage);
    }
}
