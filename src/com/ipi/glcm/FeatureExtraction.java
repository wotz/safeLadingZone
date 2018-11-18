package com.ipi.glcm;

import com.ipi.domain.GlcmMatrix;
import com.ipi.statisticaltools.Statistical;

import java.util.List;

public class FeatureExtraction {

    public static void getStatisticalData(GlcmMatrix matrix) {
        List<List<Double>> values = matrix.getElements();
        matrix.setContrast(getContrast(values));
        matrix.setCorrelation(getCorrelation(values));
        matrix.setEnergy(getAngularSecondMoment(values));
        matrix.setHomogeneity(getLocalHomogeneity(values));
    }

    private static Double getAngularSecondMoment(List<List<Double>> values) {
        Double sum = 0.0;
        for (List<Double> value : values) {
            for (Double x : value) {
                sum += x * x;
            }
        }
        return sum;
    }

    private static Double getCorrelation(List<List<Double>> values) {
        List<List<Double>> marginalProbabilities = Statistical.getMarginalProbabilities(values);
        List<Double> standardDeviations = Statistical.getStandardDeviations(marginalProbabilities);
        Double productOfHopes = Statistical.getHope(marginalProbabilities.get(0), 1.0) *
                Statistical.getHope(marginalProbabilities.get(1), 1.0);
        Double sum = 0.0;
        for (int i = 1; i < values.size(); i++) {
            for (int j = 1; j < values.get(0).size(); j++) {
                sum += (double)(i * j) * values.get(i).get(j) - productOfHopes;
            }
        }
        return sum * (1 / (standardDeviations.get(0) * standardDeviations.get(1)));
    }

    private static Double getContrast(List<List<Double>> values) {
        Double sum = 0.0;
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(0).size(); j++) {
                Double local = new Double((i - j));
                sum += Math.pow( local, 2.0) * values.get(i).get(j);
            }
        }
        return sum;
    }

    private static Double getLocalHomogeneity(List<List<Double>> values) {
        Double sum = 0.0;
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(0).size(); j++) {
                sum += (1.0 / (1.0 + Math.pow((i - j), 2.0))) * values.get(i).get(j);
            }
        }
        return sum;
    }
}
