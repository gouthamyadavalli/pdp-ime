package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData {

  public int[][] readImage(String path){
    int[][] image;
    try {
      BufferedImage img = ImageIO.read(new File(path));
      int height = img.getHeight();
      int width = img.getWidth();

      image = new int[width][height];

      for(int i=0; i<width; i++){
        for(int j=0; j<height; j++){
          image[i][j] = img.getRGB(i,j);
        }
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return image;
  }

  public int[][][] splitRGB(int[][] image){
    int width = image.length;
    int height = image[0].length;

    int[][][] rgb_split = new int[3][width][height];

    for(int i=0; i<width; i++){
      for (int j = 0; j<height; j++){
        int rgb = image[i][j];

        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        rgb_split[0][i][j] = red;
        rgb_split[1][i][j] = green;
        rgb_split[2][i][j] = blue;
      }
    }
    return rgb_split;
  }

  public int[][] combineRGB(int[][] red, int[][] green, int[][] blue){
    int width = red.length;
    int height = red[0].length;

    int[][] comb = new int[width][height];
    for(int i=0; i<width; i++){
      for (int j = 0; j<height; j++){
        int rgb = red[i][j];
        rgb = (rgb << 8) + green[i][j];
        rgb = (rgb << 8) + blue[i][j];

        comb[i][j] = rgb;
      }
    }
    return comb;
  }

  public void saveImage(int[][] image, String path){
    int width = image.length;
    int height = image[0].length;

    BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int i=0; i<width; i++){
      for (int j = 0; j<height; j++) {
        buf.setRGB(i,j, image[i][j]);
      }
    }

    try{
      ImageIO.write(buf, "png", new File(path));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
