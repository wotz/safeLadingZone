package com.ipi.glcm;

import com.ipi.domain.GlcmFeatures;
import com.ipi.domain.GlcmMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public final class Glcm {

    public Glcm() {
    }

    public static void getGlcm(List<List<Integer>> image, int d) {
        int length = takeMaximumGrayLevel(image);
        GlcmFeatures features = makeGlcm(image, d,  length);
        features.getFortyFiveDegree().getElements().forEach( f -> {
            f.forEach( g -> System.out.printf("%2d ", g));
            System.out.println();
        });
    }

    private static GlcmFeatures makeGlcm(List<List<Integer>> image, int d, int length) {
        GlcmFeatures features = new GlcmFeatures( d, length);
        NeighborCounter.countOccurrences(image, features);
        return features;
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