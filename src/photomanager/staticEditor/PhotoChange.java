package photomanager.staticEditor;

import java.awt.image.BufferedImage;
import photomanager.filtr.Constant;

public class PhotoChange {

    

    public PhotoChange() {

    }

    static public BufferedImage turn(BufferedImage image, double degree) {

        double rad = -degree * Math.PI / 180;
        int newWidth, newHeight;
        double curtmp = Math.pow( image.getHeight(), 2) + Math.pow(image.getWidth(), 2);
        newHeight = newWidth = (int) (Math.round(Math.sqrt(curtmp)
        ));
        BufferedImage newImage = new BufferedImage(newWidth, newHeight,
                BufferedImage.TYPE_INT_RGB);

        for (int n = 0; n < newImage.getWidth(); n++) {
            for (int m = 0; m < newImage.getHeight(); m++) {

                newImage.setRGB(n, m, Constant.BACKGROUND);
            }
        }

        int X = (newWidth - image.getWidth()) / 2;
        int Y = (newHeight - image.getHeight()) / 2;

        double normalDegree;
        int newX;
        int newY;
        for (int n = 0; n < newImage.getWidth(); n++) {
            for (int m = 0; m < newImage.getHeight(); m++) {
                double segment = Math.sqrt(Math.pow((newWidth / 2 - n), 2) + Math.pow((newHeight / 2 - m), 2));
                int normal = newWidth / 2 - n;
                if (segment != 0) {
                    normalDegree = Math.acos(Math.abs(normal) / segment);
                } else {
                    normalDegree = 0;
                }
                if ((m >= newHeight / 2 && n < newWidth / 2) || (m < newHeight / 2 && n >= newWidth / 2)) {
                    normalDegree = normalDegree * (-1);
                }
                if (normal > 0) {
                    newX = (int) (Math.round(newWidth / 2 - Math.cos(normalDegree + rad) * segment - X));
                    newY = (int) (Math.round(newHeight / 2 - Math.sin(normalDegree + rad) * segment - Y));
                } else {
                    newX = (int) (Math.round(newWidth / 2 - Math.cos(normalDegree + rad + Math.PI) * segment - X));
                    newY = (int) (Math.round(newHeight / 2 - Math.sin(normalDegree + rad + Math.PI) * segment - Y));
                }

                if (newX >= 0 && newY >= 0 && newX <= image.getWidth() - 1 && newY <= image.getHeight() - 1) {
                    int newPixel = image.getRGB(newX, newY);
                    newImage.setRGB(n, m, newPixel);
                }
            }
        }

        return newImage;
    }

    static public BufferedImage zoom(BufferedImage image, double zoom) {
        int newWidth = (int) (image.getWidth() * zoom);
        int newHeight = (int) (image.getHeight() * zoom);
        
        BufferedImage newImage = new BufferedImage(newWidth, newHeight,BufferedImage.TYPE_INT_RGB);
        for (int n = 0; n < newWidth; n++) {
            for (int m = 0; m < newHeight; m++) {
                int pixel = image.getRGB((int) (n / zoom), (int) (m / zoom));
                newImage.setRGB(n, m, pixel);
            }
        }
        
        return newImage;
    }

}
