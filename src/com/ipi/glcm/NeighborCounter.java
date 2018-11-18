package com.ipi.glcm;

import com.ipi.domain.GlcmFeatures;
import com.ipi.domain.GlcmMatrix;
import com.ipi.util.ConstantsAngles;

import java.util.ArrayList;
import java.util.List;

public final class NeighborCounter {

    public static void countOccurrences(List<List<Integer>> image, GlcmFeatures matrix) {
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(0).size(); j++) {
                List<Integer> current = makeList(i, j);
                countNeighborhood(image, matrix, current);
            }
        }
    }

    private static void countNeighborhood(List<List<Integer>> image, GlcmFeatures matrix, List<Integer> current) {
        for (int angle : ConstantsAngles.ANGLES) {
            choiceAngle(image, matrix, current, angle);
        }
    }

    private static void choiceAngle(List<List<Integer>> image, GlcmFeatures matrix, List<Integer> current, int angle) {
        switch (angle) {
            case 0:
                zeroDegreeCounter(image, current, matrix.getZeroDegree());
                break;
            case 45:
                fortyFiveDegreeCounter(image, current, matrix.getFortyFiveDegree());
                break;
            case 90:
                break;
            case 135:
                break;
        }
    }

    private static void zeroDegreeCounter(List<List<Integer>> image, List<Integer> current, GlcmMatrix glcmMatrix) {
        if ((current.get(1) + glcmMatrix.getD()) < image.get(0).size()) {
            int i = image.get(current.get(0)).get(current.get(1));
            int j = image.get(current.get(0)).get(current.get(1) + glcmMatrix.getD());
            glcmMatrix.incrementElement(i, j);
        }
    }

    private static void fortyFiveDegreeCounter(List<List<Integer>> image, List<Integer> current,
            GlcmMatrix glcmMatrix) {
        if (current.get(0) - glcmMatrix.getD() >=  0 && image.get(0).size()  - current.get(1) > glcmMatrix.getD()) {
            int i = image.get(current.get(0)).get(current.get(1));
            int j = image.get(current.get(0) - glcmMatrix.getD()).get(current.get(1) + glcmMatrix.getD());
            glcmMatrix.incrementElement(i, j);
        }
    }

    private static void ninetyDegreeCounter(List<List<Integer>> image, List<Integer> current,
            GlcmMatrix glcmMatrix) {
    }

    private static List<Integer> makeList(int i, int j) {
        List<Integer> positions = new ArrayList<>();
        positions.add(i);
        positions.add(j);
        return positions;
    }

}
