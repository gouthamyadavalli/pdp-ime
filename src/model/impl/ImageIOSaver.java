package model.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.intf.ImageModel;
import model.intf.ImageSaver;

public class ImageIOSaver implements ImageSaver {

//  private boolean isValidType(String type) {
//    if ((!"jpeg".equalsIgnoreCase(type))
//    ||(!))
//  }
  @Override
  public void saveImage(ImageModel imageModel, String path, String type) {



    int width = imageModel.getWidth();
    int height = imageModel.getHeight();

    BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int i=0; i<width; i++){
      for (int j = 0; j<height; j++) {
        int rgb = imageModel.getRed(i,j);
        rgb = (rgb << 8) + imageModel.getGreen(i,j);
        rgb = (rgb << 8) + imageModel.getBlue(i,j);

        buf.setRGB(i,j,rgb);
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
}
