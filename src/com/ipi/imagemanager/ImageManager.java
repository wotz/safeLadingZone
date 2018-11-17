package com.ipi.imagemanager;

import java.awt.image.BufferedImage;

public class ImageManager {

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

}