package model.impl;

import java.rmi.NoSuchObjectException;
import java.util.HashSet;
import java.util.Set;

import model.intf.Image;
import model.intf.ImageModel;
import model.intf.ImageProcessor;

public class ImageModelImpl implements ImageModel {

  private final Set<Image> images;

  private ImageProcessor imageProcessor;

  public ImageModelImpl() {
    this.images = new HashSet<Image>();
    imageProcessor = new RGBImageProcessor();
  }

  private boolean isValidType(String type) {
    String[] validImageIOTypes = {"jpg", "jpeg", "png", "gif"};

    for (String validType : validImageIOTypes) {
      if (!type.equalsIgnoreCase(validType)) {
        return false;
      }
    }
    return true;
  }

  private Image getImage(String name) throws NoSuchObjectException {
    for (Image i : images) {
      if (i.getName().equals(name)) {
        return i;
      }
    }
    throw new NoSuchObjectException("Image not found");
  }

  @Override
  public void load(String path, String name) {

    int index = path.lastIndexOf(".");
    Image image;
    if (index > 0) {
      String type = path.substring(index + 1);
      if ("ppm".equalsIgnoreCase(type)) {
        image = new PPMImageLoader().loadImage(path, name);
      } else if (isValidType(type)) {
        image = new ImageIOLoader().loadImage(path, name);
      } else {
        throw new IllegalArgumentException("Image type not supported");
      }
    } else {
      throw new IllegalArgumentException("Path Invalid!");
    }

    images.add(image);

  }

  @Override
  public void save(String path, String name) {
    Image image;
    try {
      image = getImage(name);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e);
    }
    int index = path.lastIndexOf(".");
    if (index > 0) {
      String type = path.substring(index + 1);
      if ("ppm".equalsIgnoreCase(type)) {
        new PPMImageSaver().saveImage(image, path, "ppm");
      } else if (isValidType(type)) {
        new ImageIOSaver().saveImage(image, path, type);
      } else {
        throw new IllegalArgumentException("Image type not supported");
      }
    } else {
      new ImageIOSaver().saveImage(image, path, "png");
    }
  }

  @Override
  public void RGBSplit(String name, String redName, String greenName, String blueName) {
    Image image;
    try {
      image = getImage(name);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e);
    }
    images.add(imageProcessor.getRedComponent(image, redName));
    images.add(imageProcessor.getBlueComponent(image, blueName));
    images.add(imageProcessor.getGreenComponent(image, greenName));
  }

  @Override
  public void brighten(int factor, String name) {
    Image image;
    try {
      image = getImage(name);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void blur(Image image, String name) {

  }

  @Override
  public void sharpen(Image image, String name) {

  }

  @Override
  public void horizontalFlip(Image image, String name) {

  }

  @Override
  public void verticalFlip(Image image, String name) {

  }

  @Override
  public void greyScale(Image image, String name) {

  }

  @Override
  public void sepia(Image image, String name) {

  }

}

