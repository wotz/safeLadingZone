package com.ipi.glcm;

import com.ipi.domain.GlcmMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public final class Glcm {

    public Glcm() {
    }

    public static void getGlcm(List<List<Integer>> image,  Boolean symmetric, int d, int angle) {
        int length = takeMaximumGrayLevel(image);
        GlcmMatrix glcmMatrix = makeGlcm(image, symmetric, d, angle, length);
        glcmMatrix.getElements().forEach( f -> {
            f.forEach( g -> System.out.printf("%2d ", g));
            System.out.println();
        });
    }

    private static GlcmMatrix makeGlcm(List<List<Integer>> image,  Boolean symmetric, int d, int angle, int length) {
        GlcmMatrix matrix = new GlcmMatrix(symmetric, d, angle, length);
        matrix.initializeElements();
        NeighborCounter.countOccurrences(image, matrix);
        return matrix;
    }


    public static int takeMaximumGrayLevel(List<List<Integer>> image) {
        List<List<Integer>> clone = new ArrayList<>(image);
        int maxLevel = 0;
        for (List<Integer> intensities : clone) {
            OptionalInt newMax = intensities.stream().mapToInt(Integer::intValue).max();
            if (newMax.isPresent() && newMax.getAsInt() > maxLevel) {
                maxLevel = newMax.getAsInt();
            }
        }
        return maxLevel;
    }



}