package com.ipi.util;

import java.util.ArrayList;
import java.util.List;

public final class TestsOfGlcm {


    public TestsOfGlcm() {
    }


    public static List<List<Integer>> doTestMatrix() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(doTheLineOne());
        result.add(doTheLineTwo());
        result.add(doTheLineTwoLine());
        result.add(doTheLineThree());
        result.add(doTheLineFour());
        result.add(doTheLineFive());
        result.add(doTheLineFive());
        return result;
    }

    private static List<Integer> doTheLineOne() {
        List<Integer> lineOne = new ArrayList<>();
        lineOne.add(0);
        lineOne.add(0);
        lineOne.add(3);
        lineOne.add(2);
        lineOne.add(2);
        return  lineOne;
    }

    private static List<Integer> doTheLineTwo() {
        List<Integer> lineTwo = new ArrayList<>();
        lineTwo.add(2);
        lineTwo.add(0);
        lineTwo.add(1);
        lineTwo.add(0);
        lineTwo.add(2);
        return  lineTwo;
    }

    private static List<Integer> doTheLineTwoLine() {
        List<Integer> lineTwo = new ArrayList<>();
        lineTwo.add(2);
        lineTwo.add(0);
        lineTwo.add(2);
        lineTwo.add(0);
        lineTwo.add(2);
        return  lineTwo;
    }

    private static List<Integer> doTheLineThree() {
        List<Integer> lineThree = new ArrayList<>();
        lineThree.add(1);
        lineThree.add(0);
        lineThree.add(1);
        lineThree.add(0);
        lineThree.add(2);
        return  lineThree;
    }

    private static List<Integer> doTheLineFour() {
        List<Integer> lineFour = new ArrayList<>();
        lineFour.add(2);
        lineFour.add(1);
        lineFour.add(0);
        lineFour.add(0);
        lineFour.add(2);
        return  lineFour;

    }

    private static List<Integer> doTheLineFive() {
        List<Integer> lineFive = new ArrayList<>();
        lineFive.add(2);
        lineFive.add(0);
        lineFive.add(0);
        lineFive.add(0);
        lineFive.add(3);
        return  lineFive;
    }


}
