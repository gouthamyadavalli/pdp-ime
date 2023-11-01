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
  public Image[] RGBSplit(String name, String redName, String greenName, String blueName) {
    Image image;
    Image[] splitImages = new Image[3];
    try {
      image = getImage(name);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e);
    }
    Image red = imageProcessor.getRedComponent(image, redName);
    Image green = imageProcessor.getGreenComponent(image, greenName);
    Image blue = imageProcessor.getBlueComponent(image, blueName);
    splitImages[0] = red;
    splitImages[1] = green;
    splitImages[2] = blue;

    images.add(red);
    images.add(green);
    images.add(blue);
    return splitImages;
  }

  @Override
  public Image brighten(int factor, String name, String newName) {
    Image image;
    Image resultImage;
    try {
      image = getImage(name);
      resultImage = imageProcessor.brighten(image, factor, newName);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e);
    }
    return resultImage;
  }

  @Override
  public Image blur(String name, String newName) {
    return null;
  }

  @Override
  public Image sharpen(String name, String newName) {
    return null;
  }

  @Override
  public Image getValueComponent(String name, String newName) {
    return null;
  }

  @Override
  public Image getIntensityComponent(String name, String newName) {
    return null;
  }

  @Override
  public Image getLumaComponent(String name, String newName) {
    return null;
  }


  @Override
  public Image horizontalFlip(String name, String newName) {
    return null;
  }

  @Override
  public Image verticalFlip(String name, String newName) {
    return null;
  }

  @Override
  public Image sepia(String name, String newName) {
    return null;
  }

  @Override
  public Image greyscale(String name, String newName) {
    return null;
  }

  @Override
  public Image getRedComponent(String name, String newName) {
    return null;
  }

  @Override
  public Image getGreenComponent(String name, String newName) {
    return null;
  }

  @Override
  public Image getBlueComponent(String name, String newName) {
    return null;
  }

  @Override
  public Image getRGBCombined(String newName, String redName, String greenName, String blueName) {
    return null;
  }


}

