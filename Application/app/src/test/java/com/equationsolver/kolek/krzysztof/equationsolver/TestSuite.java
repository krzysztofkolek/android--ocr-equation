package com.equationsolver.kolek.krzysztof.equationsolver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ImageLoaderUnitTest.class,
        ImagePreparationUnitTest.class,
        OCRUnitTest.class,
        SumAlgorithmUnitTest.class })
public class TestSuite {
}
