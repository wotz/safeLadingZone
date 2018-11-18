package com.ipi.util;

import java.util.ArrayList;
import java.util.List;

public final class TestsOfGlcm {


    public TestsOfGlcm() {
    }


    public static List<List<Double>> doTestMatrix() {
        List<List<Double>> result = new ArrayList<>();
        result.add(doTheLineOne());
        result.add(doTheLineTwo());
        result.add(doTheLineTwoLine());
        result.add(doTheLineThree());
        result.add(doTheLineFour());
        result.add(doTheLineFive());
        result.add(doTheLineFive());
        return result;
    }

    private static List<Double> doTheLineOne() {
        List<Double> lineOne = new ArrayList<>();
        lineOne.add(0.0);
        lineOne.add(0.0);
        lineOne.add(3.0);
        lineOne.add(2.0);
        lineOne.add(2.0);
        return  lineOne;
    }

    private static List<Double> doTheLineTwo() {
        List<Double> lineTwo = new ArrayList<>();
        lineTwo.add(2.0);
        lineTwo.add(0.0);
        lineTwo.add(1.0);
        lineTwo.add(0.0);
        lineTwo.add(2.0);
        return  lineTwo;
    }

    private static List<Double> doTheLineTwoLine() {
        List<Double> lineTwo = new ArrayList<>();
        lineTwo.add(2.0);
        lineTwo.add(0.0);
        lineTwo.add(2.0);
        lineTwo.add(0.0);
        lineTwo.add(2.0);
        return  lineTwo;
    }

    private static List<Double> doTheLineThree() {
        List<Double> lineThree = new ArrayList<>();
        lineThree.add(1.0);
        lineThree.add(0.0);
        lineThree.add(1.0);
        lineThree.add(0.0);
        lineThree.add(2.0);
        return  lineThree;
    }

    private static List<Double> doTheLineFour() {
        List<Double> lineFour = new ArrayList<>();
        lineFour.add(2.0);
        lineFour.add(1.0);
        lineFour.add(0.0);
        lineFour.add(0.0);
        lineFour.add(2.0);
        return  lineFour;

    }

    private static List<Double> doTheLineFive() {
        List<Double> lineFive = new ArrayList<>();
        lineFive.add(2.0);
        lineFive.add(0.0);
        lineFive.add(0.0);
        lineFive.add(0.0);
        lineFive.add(3.0);
        return  lineFive;
    }


}
