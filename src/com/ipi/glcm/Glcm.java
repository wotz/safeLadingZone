package com.ipi.glcm;

import com.ipi.domain.GlcmFeatures;
import com.ipi.statisticaltools.Statistical;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public final class Glcm {

    public Glcm() {
    }

    public static void getGlcm(List<List<Integer>> image, int d) {
        int length = takeMaximumGrayLevel(image);
        GlcmFeatures features = makeGlcm(image, d,  length);

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