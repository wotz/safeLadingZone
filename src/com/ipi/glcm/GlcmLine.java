package com.ipi.glcm;

import com.ipi.domain.GlcmMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public final class GlcmLine {


    //    private static final int[] DEGREES = {0, 45, 90, 135};
    //
    //    public Glcm() {
    //    }
    //
    //    public static void doMatrixGlcmWithInteger() {
    //        List<List<Integer>> image = TestsOfGlcm.doTestMatrix();
    //        int length = takeMaximumGrayLevel(image);
    //
    //        image.forEach( f -> {
    //            f.forEach( g -> {
    //                System.out.print(g + " ");
    //            });
    //            System.out.println();
    //        });
    //        System.out.println();
    //        System.out.println();
    //
    //        GlcmMatrix glcmMatrix = makeGlcm(image, length, 1, 0);
    //        glcmMatrix.getElements().forEach(f -> {
    //            f.forEach(g -> System.out.print(g + " "));
    //            System.out.println();
    //        });
    //        System.out.println();
    //
    //    }
    //
    //    public static int takeMaximumGrayLevel(List<List<Integer>> image) {
    //        List<List<Integer>> clone = new ArrayList<>(image);
    //        int maxLevel = 0;
    //        for (List<Integer> intensities : clone) {
    //            OptionalInt newMax = intensities.stream().mapToInt(Integer::intValue).max();
    //            if (newMax.isPresent() && newMax.getAsInt() > maxLevel) {
    //                maxLevel = newMax.getAsInt();
    //            }
    //        }
    //        return maxLevel;
    //    }
    //
    //    private static GlcmMatrix makeGlcm(List<List<Integer>> image, int length, int d, int angle) {
    //        GlcmMatrix angleDegrees = new GlcmMatrix(d, angle, length);
    //        List<List<Integer>> elements = new ArrayList<>();
    //        for (int i = 0; i <= length; i++) {
    //            List<Integer> jElements = new ArrayList<>();
    //            for (int j = 0; j <= length; j++) {
    //                List<Integer> glcmPositions = makeList(i, j);
    //                jElements.add(countOccurrences(image, angle, glcmPositions));
    //            }
    //            elements.add(new ArrayList<>(jElements));
    //        }
    //        angleDegrees.setElements(elements);
    //        return angleDegrees;
    //    }

    //    private static int countOccurrences(List<List<Integer>> image, int angle, List<Integer> glcm) {
    //        int count = 0;
    //        for (int i = 0; i < image.size(); i++) {
    //            for (int j = 0; j < image.get(0).size(); j++) {
    //                List<Integer> current = makeList(i, j);
    //                int temp = countNeighborhood(image, angle, glcm, current);
    //                count += temp;
    //            }
    //        }
    //        return count;
    //    }
    //
    //    private static int countNeighborhood(List<List<Integer>> image, int angle, List<Integer> glcm,
    //            List<Integer> current) {
    //
    //        if (image.get(current.get(0)).get(current.get(1)) != glcm.get(0)) {
    //            return 0;
    //        }
    //        Boolean validation = Boolean.FALSE;
    //        switch (angle) {
    //            case 0:
    //                validation = zeroDegreeValidation(image, glcm, current);
    //                break;
    //            case 45:
    //                validation = fortyFiveDegreeValidation(image, glcm, current);
    //                break;
    //            case 90:
    //                validation = ninetyDegreeValidation(image, glcm, current);
    //                break;
    //            case 135:
    //                validation = oneHundredThirtyFiveDegreeValidation(image, glcm, current);
    //                break;
    //        }
    //        return validation ? 1 : 0;
    //    }
    //
    //    private static Boolean zeroDegreeValidation(List<List<Integer>> image, List<Integer> glcm, List<Integer> current) {
    //        if ((current.get(1) + 1) == image.get(0).size()) {
    //            return Boolean.FALSE;
    //        }
    //        return image.get(current.get(0)).get(current.get(1) + 1) == glcm.get(1);
    //    }
    //
    //    private static Boolean fortyFiveDegreeValidation(List<List<Integer>> image, List<Integer> glcm,
    //            List<Integer> current) {
    //        if (current.get(0) == 0 || (current.get(1) + 1) == image.get(0).size()) {
    //            return Boolean.FALSE;
    //        }
    //        return image.get(current.get(0) - 1).get(current.get(1) + 1) == glcm.get(1);
    //    }
    //
    //    private static Boolean ninetyDegreeValidation(List<List<Integer>> image, List<Integer> glcm,
    //            List<Integer> current) {
    //        if ((current.get(1) + 1) == image.get(0).size()) {
    //            return Boolean.FALSE;
    //        }
    //        return image.get(current.get(0)).get(current.get(1) + 1) == glcm.get(1);
    //    }
    //
    //    private static Boolean oneHundredThirtyFiveDegreeValidation(List<List<Integer>> image, List<Integer> glcm,
    //            List<Integer> current) {
    //        if ((current.get(0) + 1) == image.size() || (current.get(1) + 1) == image.get(0).size()) {
    //            return Boolean.FALSE;
    //        }
    //        return image.get(current.get(0)).get(current.get(1) + 1) == glcm.get(1);
    //    }
    //
    //    private static List<Integer> makeList(int i, int j) {
    //        List<Integer> glcmPositions = new ArrayList<>();
    //        glcmPositions.add(i);
    //        glcmPositions.add(j);
    //        return glcmPositions;
    //    }

}
