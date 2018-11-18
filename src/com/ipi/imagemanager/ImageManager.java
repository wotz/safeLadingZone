package com.ipi.imagemanager;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class ImageManager {

    public static double takeMaximumGrayLevel(List<List<Double>> image) {
        List<List<Double>> clone = new ArrayList<>(image);
        Double maxLevel = 0.0;
        for (List<Double> intensities : clone) {
            OptionalDouble newMax = intensities.stream().mapToDouble(Double::doubleValue).max();
            if (newMax.isPresent() && newMax.getAsDouble() > maxLevel) {
                maxLevel = newMax.getAsDouble();
            }
        }
        return maxLevel;
    }


    // Transforma img em escala de cinza
    public static BufferedImage toGrayScale(BufferedImage img) {
        BufferedImage grayscale = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for (int i = 0; i < img.getWidth(); ++i) {
            for (int j = 0; j < img.getHeight(); ++j) {
                int rgb = img.getRGB(i, j);
                int r = (rgb >> 16) & 255;
                int g = (rgb >> 8) & 255;
                int b = (rgb & 255);
                int graylevel =  (int)(0.2125*r + 0.7154*g + 0.0721*b);
                int gray = (graylevel << 16) + (graylevel << 8) + graylevel;
                grayscale.setRGB(i, j, gray);
            }
        }
        return grayscale;
    }

    public static List<List<Double>> convertToDoubleList(BufferedImage image, int d, int angle) {
        BufferedImage grayImage = toGrayScale(image);
        List<List<Double>> newImage = new ArrayList<>();
        for (int i = 0; i < grayImage.getWidth(); i ++){
            List<Double> jValues = new ArrayList<>();
            for (int j = 0; j < grayImage.getHeight(); j ++) {
                Color pixel = new Color(grayImage.getRGB(i, j));
                int blue = pixel.getBlue();
                jValues.add((double)blue);
            }
            newImage.add(jValues);
        }
        return newImage;
    }

    // Lê uma imagem no caminho path
    public static BufferedImage read(String path) throws IOException {
        BufferedImage imagem = ImageIO.read(new File(path));
        return imagem;
    }

    // Salva uma imagem no caminho path
    public static void write(BufferedImage imagem, String path) throws IOException{
        File output_file = new File(path);

        ImageIO.write(imagem, "bmp", output_file);
    }

}
