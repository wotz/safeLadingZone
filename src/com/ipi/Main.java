package com.ipi;

import com.ipi.domain.GlcmFeatures;
import com.ipi.filemodule.WriterModule;
import com.ipi.glcm.Glcm;
import com.ipi.util.TestsOfGlcm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Double>> image = TestsOfGlcm.doTestMatrix();
        GlcmFeatures glcmFeatures = Glcm.getGlcm(image, 1);

        WriterModule.saveInformations("/opt/projetos/safeLadingZone/src/com/ipi/data/classifier/"
                , "luisa", glcmFeatures);
    }
    //        GlcmFeatures features = Glcm.getGlcm(image, 1);
    //        System.out.println(features.getZeroDegree().toString());
    //        System.out.println(features.getFortyFiveDegree().toString());
    //        System.out.println(features.getNinetyDegree().toString());
    //        System.out.println(features.getOneHundredThirtyFiveDegre().toString());
}
