package photomanager.segmentation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Segmentation {
	private ArrayList<Pixel> points = new ArrayList<Pixel>();
	private ArrayList<Pixel> newCentroid;
	int width;
	int height;
	BufferedImage image;
	//boolean changeCentroid = true;
	int numSegments;

	public Segmentation(BufferedImage image, int numSegment) {
		width = image.getWidth();
		height = image.getHeight();
		this.image = image;
		int x, y;
		Pixel mainPixel;
		this.numSegments = numSegment;
		for (int i = 0; i < numSegment; i++) {
			x = (int) (Math.random() * image.getWidth());
			y = (int) (Math.random() * image.getHeight());
			int centoid = image.getRGB(x, y);
			int redCentroid = (centoid >> 16) & 0xff;
			int greenCentoid = (centoid >> 8) & 0xff;
			int blueCentoid = centoid & 0xff;

			mainPixel = new Pixel(x, y);
			mainPixel.setRed(redCentroid);
			mainPixel.setBlue(blueCentoid);
			mainPixel.setGreen(greenCentoid);
			points.add(mainPixel);
		}
	}

	public BufferedImage segmentCheck() {
		int numPoint = 0;
		
                {
			for (int countX = 0; countX < width; countX++) {
				for (int countY = 0; countY < height; countY++) {
					int pixel = image.getRGB(countX, countY);
					
					int redPixel = (pixel >> 16) & 0xff;
					int greenPixel = (pixel >> 8) & 0xff;
					int bluePixel = pixel & 0xff;


					int min = 98526554;
					for (int countCentr = 0; countCentr < points.size(); countCentr++) {

						int redCentroid = points.get(countCentr).getRed();
						int greenCentoid = points.get(countCentr).getGreen();
						int blueCentoid = points.get(countCentr).getBlue();

						int minRed = Math.abs(redCentroid - redPixel);
						int minGreen = Math.abs(greenCentoid - greenPixel);
						int minBlue = Math.abs(blueCentoid - bluePixel);

						int temp = minRed + minGreen + minBlue;

						if (min > temp) {

							min = temp;
							numPoint = countCentr;
						}
					}

					points.get(numPoint).setPixel(countX, countY);
				}
			}

			//mainPoint();
		}

		BufferedImage newImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		
                points.stream().forEach((mainPoint) -> {
                    for (int countPixel = 0; countPixel < mainPoint.getListPixel().size(); countPixel++) {
                        Pixel pointPixel = mainPoint.getListPixel().get(countPixel);
                        mainPoint.getRed();
                        int colorPixel = (mainPoint.getRed() << 16) | (mainPoint.getGreen() << 8) | mainPoint.getBlue();
                        newImage.setRGB(pointPixel.getX(), pointPixel.getY(), colorPixel);
                    }
            });
		
		
		return newImage;
	}

//	public void mainPoint() {
//		int sumRed = 0;
//		int sumGreen = 0;
//		int sumBlue = 0;
//		int newRed = 0;
//		int newGreen = 0;
//		int newBlue = 0;
//		newCentroid = new ArrayList<Pixel>();
//		for (int countCentroid = 0; countCentroid < points.size(); countCentroid++) {
//                    int tmp = points.get(countCentroid)	.getListPixel().size();
//			for (int countPixel = 0; countPixel < tmp; countPixel++) {
//				Pixel pointPixel = points.get(countCentroid).getListPixel()
//						.get(countPixel);
//				int pixel = image.getRGB(pointPixel.getX(), pointPixel.getY());
//
//				int redPixel = (pixel >> 16) & 0xff;
//				int greenPixel = (pixel >> 8) & 0xff;
//				int bluePixel = pixel & 0xff;
//
//				sumRed += redPixel;
//				sumGreen += greenPixel;
//				sumBlue += bluePixel;
//			}
//			newRed = sumRed / points.get(countCentroid).getListPixel().size();
//			newGreen = sumGreen
//					/ points.get(countCentroid).getListPixel().size();
//			newBlue = sumBlue
//					/ points.get(countCentroid).getListPixel().size();
//
//			Pixel point = new Pixel(0, 0);
//			point.setRed(newRed);
//			point.setGreen(newGreen);
//			point.setBlue(newBlue);
//			newCentroid.add(point);
//
//			sumRed = 0;
//			sumGreen = 0;
//			sumBlue = 0;
//		}
//
//		int check = 0;
//		changeCentroid = false;
//		for (int count = 0; count < newCentroid.size(); count++) {
//			int red = newCentroid.get(count).getRed();
//			int green = newCentroid.get(count).getGreen();
//			int blue = newCentroid.get(count).getBlue();
//			for (int count1 = 0; count1 < points.size(); count1++) {
//				int lastred = points.get(count).getRed();
//				int lastgreen = points.get(count).getGreen();
//				int lastblue = points.get(count).getBlue();
//
//				if (red != lastred || green != lastgreen || blue != lastblue) {
//					check++;
//				}
//			}
//
//			if (check == points.size()){
//				changeCentroid = true;
//				points.clear();
//				points.addAll(newCentroid);
//			}
//		}
//
//		
//		segmentCheck();
//	}

}
