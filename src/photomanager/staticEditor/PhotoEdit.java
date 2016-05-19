/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photomanager.staticEditor;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Администратор
 */
public class PhotoEdit {


    
    public static BufferedImage made3d(BufferedImage image, BufferedImage right) {
        for (int i = 1; i < image.getHeight()-1; i++) {
            for (int j = 1; j < image.getWidth()-1; j++) {
                int pixel = image.getRGB(j, i);
                int red1 = (image.getRGB(j-1, i-1) >> 16) & 0xff;
                int red2 = (image.getRGB(j, i) >> 16) & 0xff;
                int red3 = (image.getRGB(j+1, i+1) >> 16) & 0xff;
                
               int redSum = //((image.getRGB(j-1, i-1) >> 16) & 0xff) + 
                       ((image.getRGB(j, i) >> 16) & 0xff) //+
                       //((right.getRGB(j+1, i+1) >> 16) & 0xff)
                       ;
               int greenSum = //((image.getRGB(j-1, i-1) >> 8) & 0xff) + 
                       ((right.getRGB(j, i) >> 8) & 0xff) //+
                       //((right.getRGB(j+1, i+1) >> 8) & 0xff)
                       ;
               int blueSum = //((image.getRGB(j-1, i-1)) & 0xff) + 
                       ((right.getRGB(j, i)) & 0xff) //+
                       //((right.getRGB(j+1, i+1)) & 0xff)
                       ;
              // System.out.println(redSum);
//                redSum = (redSum-(redSum % 3))/3;
//                greenSum = (greenSum-(greenSum % 3))/3;
//                blueSum =(blueSum-(blueSum % 3))/3;
                
                if (redSum > 255) redSum = 255;
                if (greenSum > 255) greenSum = 255;
                if (blueSum > 255) blueSum = 255;
                //System.out.println(redSum);
                Color color = new Color(redSum, greenSum, blueSum);
                pixel = color.getRGB();
                image.setRGB(j, i, pixel);
            }
        }
        return image;
    }

    public static BufferedImage negativ(BufferedImage image) {
        int a;
        //PixelThread pix = new PixelThread();
        
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
    
    public static BufferedImage filtr3(BufferedImage image) {
        int redNew, greenNew, blueNew;
        for (int i = 1; i < image.getHeight()-1; i++) {
            for (int j = 1; j < image.getWidth()-1; j++) {
                int pixel = image.getRGB(j, i);
                
                int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
                
                int pixel2 = image.getRGB(j+1, i);
                int red2 = (pixel2 >> 16) & 0xff;
		int green2 = (pixel2 >> 8) & 0xff;
		int blue2 = (pixel2) & 0xff;
                
                
                
                if (Math.abs(red - red2) < 20 || Math.abs(green - green2) < 20 
                        || Math.abs(blue - blue2) < 20 )
                {
                   //System.out.println("Ok");
                    redNew = 255;
                    greenNew = 255;
                    blueNew = 255;
                }
                else 
                {
                    redNew = 0;
                    greenNew = 0;
                    blueNew = 0;
                }
                
//                redNew = PhotoEdit.useMatrix(image, i, j);
//                greenNew = (int) ( 0.343 * red + 0.686 * green + 0.168 * blue);
//                blueNew = (int) ( 0.272 * red + 0.534 * green + 0.131* blue);
         
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

//    private static int useMatrix(BufferedImage image, int i, int j) {
//        int summ = image.getRED(j-1, i-1) + image.getRED( j, i-1) + image.getRED(j+1, i-1) +
//                image.getRED(j-1, i) + image.getRED(j, i) + image.getRED(j+1, i) +
//                image.getRED(j-1, i+1) + image.getRED(j, i+1) + image.getRED(j+1, i+1);
//    }

 
}

