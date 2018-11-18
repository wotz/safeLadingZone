package com.ipi.glcm;

import com.ipi.domain.GlcmFeatures;
import com.ipi.domain.GlcmMatrix;

import java.util.ArrayList;
import java.util.List;

public final class NeighborCounter {

    public static void countOccurrences(List<List<Double>> image, GlcmFeatures matrix) {
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(0).size(); j++) {
                List<Integer> current = makeList(i, j);
                countNeighborhood(image, matrix, current);
            }
        }
    }

    private static void countNeighborhood(List<List<Double>> image, GlcmFeatures matrix, List<Integer> current) {
        zeroDegreeCounter(image, current, matrix.getZeroDegree());
        fortyFiveDegreeCounter(image, current, matrix.getFortyFiveDegree());
        ninetyDegreeCounter(image, current, matrix.getNinetyDegree());
        oneHundredThirtyFiveCounter(image, current, matrix.getOneHundredThirtyFiveDegre());
    }


    private static void zeroDegreeCounter(List<List<Double>> image, List<Integer> current, GlcmMatrix glcmMatrix) {
        if ((current.get(1) + glcmMatrix.getD()) < image.get(0).size()) {
            int i = image.get(current.get(0)).get(current.get(1)).intValue();
            int j = image.get(current.get(0)).get(current.get(1) + glcmMatrix.getD()).intValue();
            glcmMatrix.incrementElement(i, j);
        }
    }

    private static void fortyFiveDegreeCounter(List<List<Double>> image, List<Integer> current,
            GlcmMatrix glcmMatrix) {
        if (current.get(0) - glcmMatrix.getD() >=  0 && image.get(0).size()  - current.get(1) > glcmMatrix.getD()) {
            int i = image.get(current.get(0)).get(current.get(1)).intValue();
            int j = image.get(current.get(0) - glcmMatrix.getD()).get(current.get(1) + glcmMatrix.getD()).intValue();
            glcmMatrix.incrementElement(i, j);
        }
    }

    private static void ninetyDegreeCounter(List<List<Double>> image, List<Integer> current,
            GlcmMatrix glcmMatrix) {
        if (current.get(0) + glcmMatrix.getD() < image.size()) {
            int i = image.get(current.get(0)).get(current.get(1)).intValue();
            int j = image.get(current.get(0) + glcmMatrix.getD()).get(current.get(1)).intValue();
            glcmMatrix.incrementElement(i, j);
        }
    }

    private static void oneHundredThirtyFiveCounter(List<List<Double>> image, List<Integer> current,
            GlcmMatrix glcmMatrix) {
        if (current.get(0) + glcmMatrix.getD() < image.size() && current.get(1) + glcmMatrix.getD() < image.get(0).size()) {
            int i = image.get(current.get(0)).get(current.get(1)).intValue();
            int j = image.get(current.get(0) + glcmMatrix.getD()).get(current.get(1) + glcmMatrix.getD()).intValue();
            glcmMatrix.incrementElement(i, j);
        }
    }


    private static List<Integer> makeList(int i, int j) {
        List<Integer> positions = new ArrayList<>();
        positions.add(i);
        positions.add(j);
        return positions;
    }

}
