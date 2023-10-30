package model.impl;

import model.intf.ImageModel;
import model.intf.ImageSaver;

public class PPMImageSaver implements ImageSaver {
  @Override
  public void saveImage(ImageModel imageModel, String path, String type) {
    if(!"ppm".equalsIgnoreCase(type)){
      throw new IllegalArgumentException("Invalid save type!");
    }
  }
}
