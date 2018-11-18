package com.ipi.glcm;

import com.ipi.domain.GlcmFeatures;
import com.ipi.imagemanager.ImageManager;
import com.ipi.statisticaltools.Statistical;

import java.util.List;

public final class Glcm {

    public Glcm() {
    }

    public static GlcmFeatures getGlcm(List<List<Integer>> image, int d) {
        int length = ImageManager.takeMaximumGrayLevel(image);
        GlcmFeatures features = makeGlcm(image, d,  length);
        normalizeGlcmFeatures(features);
        getStatisticalData(features);
        return features;
    }

    private static GlcmFeatures makeGlcm(List<List<Integer>> image, int d, int length) {
        GlcmFeatures features = new GlcmFeatures( d, length);
        NeighborCounter.countOccurrences(image, features);
        return features;
    }

    private static void normalizeGlcmFeatures(GlcmFeatures glcmFeatures) {
        Statistical.normalize(glcmFeatures.getZeroDegree().getElements());
        Statistical.normalize(glcmFeatures.getFortyFiveDegree().getElements());
        Statistical.normalize(glcmFeatures.getNinetyDegree().getElements());
        Statistical.normalize(glcmFeatures.getOneHundredThirtyFiveDegre().getElements());
    }

    private static void getStatisticalData(GlcmFeatures glcmFeatures) {
        FeatureExtraction.getStatisticalData(glcmFeatures.getZeroDegree());
        FeatureExtraction.getStatisticalData(glcmFeatures.getFortyFiveDegree());
        FeatureExtraction.getStatisticalData(glcmFeatures.getNinetyDegree());
        FeatureExtraction.getStatisticalData(glcmFeatures.getOneHundredThirtyFiveDegre());

    }





}