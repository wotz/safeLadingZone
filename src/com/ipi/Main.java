package com.ipi;

import com.ipi.domain.GlcmFeatures;
import com.ipi.glcm.Glcm;
import com.ipi.util.TestsOfGlcm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> image = TestsOfGlcm.doTestMatrix();
        GlcmFeatures features = Glcm.getGlcm(image, 1);
        System.out.println(features.getZeroDegree().toString());
        System.out.println(features.getFortyFiveDegree().toString());
        System.out.println(features.getNinetyDegree().toString());
        System.out.println(features.getOneHundredThirtyFiveDegre().toString());

    }

}
