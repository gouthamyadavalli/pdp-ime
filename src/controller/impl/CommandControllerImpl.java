package controller.impl;

import static java.lang.Integer.parseInt;

import controller.intf.CommandController;
import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import model.impl.RGBImageModelImpl;
import model.intf.Image;
import model.intf.ImageModel;

/**
 * This class implements the CommandController interface. It is responsible for storing the set of
 * images and executing the commands on an image.
 */
public class CommandControllerImpl implements CommandController {

  private ImageModel imageModel;

  private final Set<Image> images;

  public CommandControllerImpl() {
    images = new HashSet<Image>();
    imageModel = new RGBImageModelImpl();
  }

  /**
   * This method executes the command on the image by calling the model.
   *
   * @param commands - the command from the input
   * @return - true if the command is exit, false otherwise
   */
  @Override
  public boolean executeCommand(String[] commands) {
    String command = commands[0].toLowerCase();
    System.out.println(Arrays.toString(commands));
    try {
      switch (command) {
        case "exit":
          return true;
        case "load":
          load(commands[1], commands[2]);
          break;
        case "save":
          save(commands[1], commands[2]);
          break;
        case "brighten":
          images.add(
              imageModel.brighten(getImage(commands[2]), parseInt(commands[1]), commands[3]));
          break;
        case "blur":
          images.add(imageModel.blur(getImage(commands[1]), commands[2]));
          break;
        case "sharpen":
          images.add(imageModel.sharpen(getImage(commands[1]), commands[2]));
          break;
        case "horizontal-flip":
          images.add(imageModel.horizontalFlip(getImage(commands[1]), commands[2]));
          break;
        case "vertical-flip":
          images.add(imageModel.verticalFlip(getImage(commands[1]), commands[2]));
          break;
        case "sepia":
          images.add(imageModel.sepia(getImage(commands[1]), commands[2]));
          break;
        case "greyscale":
          images.add(imageModel.greyscale(getImage(commands[1]), commands[2]));
          break;
        case "red-component":
          images.add(imageModel.getRedComponent(getImage(commands[1]), commands[2]));
          break;
        case "green-component":
          images.add(imageModel.getGreenComponent(getImage(commands[1]), commands[2]));
          break;
        case "blue-component":
          images.add(imageModel.getBlueComponent(getImage(commands[1]), commands[2]));
          break;
        case "value-component":
          images.add(imageModel.getValueComponent(getImage(commands[1]), commands[2]));
          break;
        case "intensity-component":
          images.add(imageModel.getIntensityComponent(getImage(commands[1]), commands[2]));
          break;
        case "luma-component":
          images.add(imageModel.getLumaComponent(getImage(commands[1]), commands[2]));
          break;
        case "rgb-split":
          Image[] splitImages = imageModel.getRGBSplit(getImage(commands[1]), commands[2],
              commands[3], commands[4]);
          images.add(splitImages[0]);
          images.add(splitImages[1]);
          images.add(splitImages[2]);
          break;
        case "rgb-combine":
          images.add(
              imageModel.getRGBCombined(commands[1], getImage(commands[2]), getImage(commands[3]),
                  getImage(commands[4])));
          break;
        default:
          throw new IllegalArgumentException("Invalid command");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * This method loads the image from the path and adds it to the set of images.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   */
  private void load(String path, String name) {
    int index = path.lastIndexOf(".");
    Image image;
    if (index > 0) {
      String type = path.substring(index + 1);
      if ("ppm".equalsIgnoreCase(type)) {
        image = new PPMImageUtil().loadImage(path, name);
      } else if (isValidType(type)) {
        image = new ImageIOUtil().loadImage(path, name);
      } else {
        throw new IllegalArgumentException("Image type not supported");
      }
    } else {
      throw new IllegalArgumentException("Path Invalid!");
    }
    images.add(image);
  }

  /**
   * This method saves the image to the path.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   */
  private void save(String path, String name) {
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
        new PPMImageUtil().saveImage(image, path, "ppm");
      } else if (isValidType(type)) {
        new ImageIOUtil().saveImage(image, path, type);
      } else {
        throw new IllegalArgumentException("Image type not supported");
      }
    } else {
      new ImageIOUtil().saveImage(image, path, "png");
    }
  }

  /**
   * This method checks if the type of the image is valid.
   *
   * @param type - the type of the image
   * @return - true if the type is valid, false otherwise
   */
  private boolean isValidType(String type) {
    String[] validImageIOTypes = {"jpg", "jpeg", "png", "gif"};

    for (String validType : validImageIOTypes) {
      if (type.equalsIgnoreCase(validType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method gets the image from the set of images.
   *
   * @param name - the name of the image
   * @return - the image
   * @throws NoSuchObjectException - if the image is not found
   */
  private Image getImage(String name) throws NoSuchObjectException {
    for (Image i : images) {
      if (i.getName().equals(name)) {
        return i;
      }
    }
    throw new NoSuchObjectException("Image not found");
  }

}
