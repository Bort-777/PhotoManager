/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager.staticEditor;

import Jama.Matrix;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Администратор
 */
public class PhotoEdit {

    public static BufferedImage made3d(BufferedImage image) {
        for (int i = 1; i < image.getHeight()-1; i++) {
            for (int j = 1; j < image.getWidth()-1; j++) {
                int pixel = image.getRGB(j, i);
                
                /*double[][] kernel = {
                    {getRED(image, j-1, i-1),getRED(image, j, i-1),getRED(image, j+1, i-1)},
                    {getRED(image, j-1, i),getRED(image, j, i),getRED(image, j+1, i)},
                    {getRED(image, j-1, i+1),getRED(image, j, i+1),getRED(image, j+1, i+1)}};
                double[][] w = {{0.05,0.075,0.05},{0.075,1.,0.075},{0.05,0.075,0.005}};
                
                Matrix kernel1 = new Matrix(kernel);
                Matrix w1 = new Matrix(w);
                
                Matrix tmp = kernel1.arrayTimes(w1);
                double sum = 0;
                for (int a=0; a<3; a++)
                    for (int b=0; b<3; b++)
                    {
                        sum=sum + tmp.get(a, b);
                    }
                int pixRED = (int) (sum * 1 / 6);
                */
                
                int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
                // TODO: dsfsd
                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;
                if (red > 255) red = 255;
                Color color = new Color(red, green, blue);
                pixel = color.getRGB();
                image.setRGB(j, i, pixel);
            }
        }
        return image;
    }

    public static BufferedImage negativ(BufferedImage image) {
        for (int i = 1; i < image.getHeight()-1; i++) {
            for (int j = 1; j < image.getWidth()-1; j++) {
                int pixel = image.getRGB(j, i);
                
                int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
                
                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;
                if (red > 255) red = 255;
                Color color = new Color(red, green, blue);
                pixel = color.getRGB();
                image.setRGB(j, i, pixel);
            }
        }
        return image;
    }
    
    public static BufferedImage sepia(BufferedImage image) {
        int redNew, greenNew, blueNew;
        for (int i = 1; i < image.getHeight()-1; i++) {
            for (int j = 1; j < image.getWidth()-1; j++) {
                int pixel = image.getRGB(j, i);
                
                int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
                
                redNew = (int) ( 0.393 * red + 0.769 * green + 0.189 * blue);
                greenNew = (int) ( 0.343 * red + 0.686 * green + 0.168 * blue);
                blueNew = (int) ( 0.272 * red + 0.534 * green + 0.131* blue);
         
                if (redNew > 255) redNew = 255;
                if (greenNew > 255) greenNew = 255;
                if (blueNew > 255) blueNew = 255;
                Color color = new Color(redNew, greenNew, blueNew);
                pixel = color.getRGB();
                image.setRGB(j, i, pixel);
            }
        }
        return image;
    }
}
