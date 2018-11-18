package com.ipi.filemodule;

import com.ipi.domain.GlcmFeatures;
import com.ipi.domain.GlcmMatrix;
import com.ipi.util.AnglesConstants;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public final class WriterModule {

    public static void saveInformations(String path, String fileName, GlcmFeatures glcmFeatures) {
        for (int angle : AnglesConstants.ANGLES) {
            String glcmPath = path + "glcm/" + fileName + "_" + angle + ".txt";
            writeGlcm(glcmPath, glcmFeatures.getGlcmMatrixByAngle(angle));
        }

        for (int angle : AnglesConstants.ANGLES) {
            String glcmPath = path + "statistical/" + fileName + "_" + angle + ".txt";
            writeStatistics(glcmPath, glcmFeatures.getGlcmMatrixByAngle(angle));
        }
    }

    private static void writeGlcm(String path, GlcmMatrix matrix) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter writer = new PrintWriter(fileWriter);
            List<List<Double>> value = matrix.getElements();
            basicInformations(matrix, writer);
            for (int i = 0; i < value.size(); i++) {
                for (int j = 0; j < value.get(0).size(); j++) {
                    writer.printf("%.5f ", value.get(i).get(j));
                }
                writer.printf("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void basicInformations(GlcmMatrix matrix, PrintWriter writer) {
        writer.printf("%.2f\n", matrix.getLength());
        writer.printf("%d\n", matrix.getD());
        writer.printf("%d\n", matrix.getAngle());
    }

    private static void writeStatistics(String path, GlcmMatrix matrix) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter writer = new PrintWriter(fileWriter);
            basicInformations(matrix, writer);
            writer.printf("%.2f\n", matrix.getContrast());
            writer.printf("%.2f\n", matrix.getCorrelation());
            writer.printf("%.2f\n", matrix.getEnergy());
            writer.printf("%.2f\n", matrix.getHomogeneity());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

}
