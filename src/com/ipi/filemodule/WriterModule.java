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
        String glcmPath = path + "glcm/" + fileName + ".txt";
        writeGlcm(glcmPath, glcmFeatures);
        glcmPath = path + "statistical/" + fileName  + ".txt";
        writeStatistics(glcmPath, glcmFeatures);
    }

    private static void writeGlcm(String path, GlcmFeatures features) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter writer = new PrintWriter(fileWriter);

            for (int angle : AnglesConstants.ANGLES) {
                GlcmMatrix matrix = features.getGlcmMatrixByAngle(angle);
                List<List<Double>> value = matrix.getElements();
                basicData(matrix, writer);
                matrixData(writer, value);
                writer.println();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void writeStatistics(String path, GlcmFeatures features) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter writer = new PrintWriter(fileWriter);

            for (int angle : AnglesConstants.ANGLES) {
                GlcmMatrix matrix = features.getGlcmMatrixByAngle(angle);
                basicData(matrix, writer);
                statisticalData(writer, matrix);
                writer.println();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void matrixData(PrintWriter writer, List<List<Double>> value) {
        for (int i = 0; i < value.size(); i++) {
            for (int j = 0; j < value.get(0).size(); j++) {
                writer.printf("%.5f ", value.get(i).get(j));
            }
            writer.printf("\n");
        }
    }

    private static void basicData(GlcmMatrix matrix, PrintWriter writer) {
        writer.printf("%.2f\n", matrix.getLength());
        writer.printf("%d\n", matrix.getD());
        writer.printf("%d\n", matrix.getAngle());
    }

    private static void statisticalData(PrintWriter writer, GlcmMatrix matrix) {
        writer.printf("%.2f\n", matrix.getContrast());
        writer.printf("%.2f\n", matrix.getCorrelation());
        writer.printf("%.2f\n", matrix.getEnergy());
        writer.printf("%.2f\n", matrix.getHomogeneity());
    }

}
