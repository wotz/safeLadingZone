package com.ipi.glcm;

import com.ipi.domain.GlcmMatrix;

import java.util.ArrayList;
import java.util.List;

public final class NeighborCounter {

    public static void countOccurrences(List<List<Integer>> image, GlcmMatrix matrix) {
        for (int i = 0; i < image.size(); i++) {
            for (int j = 1; j < image.get(0).size() - 1; j  += 2) {
                List<Integer> current = makeList(i, j);
                countNeighborhood(image, matrix, current);
            }
        }
    }

    private static void countNeighborhood(List<List<Integer>> image, GlcmMatrix matrix, List<Integer> current) {

        List<List<Integer>> pairs = new ArrayList<>();
        switch (matrix.getAngle()) {
            case 0:
                pairs = matrix.isSymmetric() ? zeroDegreeSymmetricCounter(image, current) : null;
            case 45:
                break;
            case 90:
                break;
            case 135:
                break;
        }
        updateMatrixInfo(matrix, pairs);
    }

    private static List<List<Integer>> zeroDegreeSymmetricCounter(List<List<Integer>> image, List<Integer> current) {
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> pairOne = new ArrayList<>();
        pairOne.add(image.get(current.get(0)).get(current.get(1)));
        pairOne.add(image.get(current.get(0)).get(current.get(1) + 1));
        pairs.add(pairOne);

        List<Integer> pairTwo = new ArrayList<>();
        pairTwo.add(image.get(current.get(0)).get(current.get(1)));
        pairTwo.add(image.get(current.get(0)).get(current.get(1) - 1));
        pairs.add(pairTwo);

        return pairs;
    }

    private static void updateMatrixInfo(GlcmMatrix matrix, List<List<Integer>> pairs) {
        for (List<Integer> pair : pairs) {
            matrix.incrementElement(pair.get(0), pair.get(1));
            if (matrix.isSymmetric()) {
                matrix.incrementElement(pair.get(1), pair.get(0));
            }
        }
    }

    private static List<Integer> makeList(int i, int j) {
        List<Integer> positions = new ArrayList<>();
        positions.add(i);
        positions.add(j);
        return positions;
    }

}
