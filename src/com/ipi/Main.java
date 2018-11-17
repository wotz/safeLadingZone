package com.ipi;

import com.ipi.glcm.Glcm;
import com.ipi.util.TestsOfGlcm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> image = TestsOfGlcm.doTestMatrix();
        Glcm.getGlcm(image, Boolean.TRUE, 1, 0);
    }

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
//        if ((current.get(1) + 1 ) == image.get(0).size()) {
//            return Boolean.FALSE;
//        }
//        return image.get(current.get(0)).get(current.get(1) + 1) == glcm.get(1);
//    }
//
//    private static Boolean oneHundredThirtyFiveDegreeValidation(List<List<Integer>> image, List<Integer> glcm,
//            List<Integer> current) {
//        if ((current.get(0) + 1 ) == image.size() || (current.get(1) + 1) == image.get(0).size()) {
//            return Boolean.FALSE;
//        }
//        return image.get(current.get(0)).get(current.get(1) + 1) == glcm.get(1);
//    }
}
