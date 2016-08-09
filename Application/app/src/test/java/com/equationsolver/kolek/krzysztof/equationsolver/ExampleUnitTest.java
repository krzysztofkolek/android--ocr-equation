package com.equationsolver.kolek.krzysztof.equationsolver;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        Bitmap bitmap1 = BitmapFactory.decodeFile("D:\\sum.jpg");
        assertEquals(4, 2 + 2);
    }
}