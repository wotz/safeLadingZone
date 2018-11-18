package com.ipi.statisticaltools;

import java.util.ArrayList;
import java.util.List;

public final class Statistical {

    public Statistical() {
    }

    public static List<List<Double>> normalize(List<List<Integer>> image) {
        Integer sum = 0;
        List<List<Double>> normalizedImage = new ArrayList<>();
        for (List<Integer> integers : image) {
            sum += integers.stream().mapToInt(Integer::intValue).sum();
        }
        for (List<Integer> integers : image) {
            List<Double> collumnList = new ArrayList<>();
            for (Integer integer : integers) {
                Double value = integer.doubleValue() / sum.doubleValue();

                collumnList.add(value);
            }
            normalizedImage.add(collumnList);
        }
        return  normalizedImage;
    }

}
