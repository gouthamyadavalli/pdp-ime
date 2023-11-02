package controller.impl;

import static java.lang.Integer.parseInt;

import controller.intf.CommandController;
import java.io.IOException;
import java.rmi.NoSuchObjectException;
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
  public boolean executeCommand(String[] commands, Appendable out) throws IOException {
    String command = commands[0].toLowerCase();
    switch (command) {
      case "exit":
        return true;
      case "load":
        check3Input(commands);
        String loadPath = checkFilePath(commands);
        out.append("Loading image as ").append(commands[2]).append("\n");
        load(loadPath, commands[commands.length - 1]);
        break;
      case "save":
        check3Input(commands);
        String savePath = checkFilePath(commands);
        out.append("Saving image as ").append(commands[2]).append("\n");
        save(savePath, commands[2]);
        break;
      case "brighten":
        check4Input(commands);
        out.append("Brightening image by ").append(commands[1]).append("\n");
        images.add(
            imageModel.brighten(getImage(commands[2]), parseInt(commands[1]), commands[3]));
        break;
      case "blur":
        check3Input(commands);
        out.append("Blurring image and calling it ").append(commands[2]).append(" \n");
        images.add(imageModel.blur(getImage(commands[1]), commands[2]));
        break;
      case "sharpen":
        check3Input(commands);
        out.append("Sharpening image and calling it ").append(commands[2]).append(" \n");
        images.add(imageModel.sharpen(getImage(commands[1]), commands[2]));
        break;
      case "horizontal-flip":
        check3Input(commands);
        out.append("Flipping image horizontally and calling it ").append(commands[2]).append(" \n");
        images.add(imageModel.horizontalFlip(getImage(commands[1]), commands[2]));
        break;
      case "vertical-flip":
        check3Input(commands);
        out.append("Flipping image vertically and calling it ").append(commands[2]).append(" \n");
        images.add(imageModel.verticalFlip(getImage(commands[1]), commands[2]));
        break;
      case "sepia":
        check3Input(commands);
        out.append("Transforming image to sepia and calling it ").append(commands[2]).append(" \n");
        images.add(imageModel.sepia(getImage(commands[1]), commands[2]));
        break;
      case "greyscale":
        check3Input(commands);
        out.append("Transforming image to greyscale and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.greyscale(getImage(commands[1]), commands[2]));
        break;
      case "red-component":
        check3Input(commands);
        out.append("Getting red component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getRedComponent(getImage(commands[1]), commands[2]));
        break;
      case "green-component":
        check3Input(commands);
        out.append("Getting green component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getGreenComponent(getImage(commands[1]), commands[2]));
        break;
      case "blue-component":
        check3Input(commands);
        out.append("Getting blue component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getBlueComponent(getImage(commands[1]), commands[2]));
        break;
      case "value-component":
        check3Input(commands);
        out.append("Getting value component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getValueComponent(getImage(commands[1]), commands[2]));
        break;
      case "intensity-component":
        check3Input(commands);
        out.append("Getting intensity component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getIntensityComponent(getImage(commands[1]), commands[2]));
        break;
      case "luma-component":
        check3Input(commands);
        out.append("Getting luma component of image and calling it ").append(commands[2])
            .append(" \n");
        images.add(imageModel.getLumaComponent(getImage(commands[1]), commands[2]));
        break;
      case "rgb-split":
        check5Input(commands);
        out.append("Splitting image into RGB components and calling them ").append(commands[2])
            .append(" ").append(commands[3]).append(" ").append(commands[4]).append(" \n");
        Image[] splitImages = imageModel.getRGBSplit(getImage(commands[1]), commands[2],
            commands[3], commands[4]);
        images.add(splitImages[0]);
        images.add(splitImages[1]);
        images.add(splitImages[2]);
        break;
      case "rgb-combine":
        check5Input(commands);
        out.append("Combining RGB components into image and calling it ").append(commands[2])
            .append(" \n");
        images.add(
            imageModel.getRGBCombined(commands[1], getImage(commands[2]), getImage(commands[3]),
                getImage(commands[4])));
        break;
      default:
        throw new IllegalArgumentException("Invalid command: " + command);
    }
    return false;
  }

  /**
   * This method loads the image from the path and adds it to the set of images.
   *
   * @param path - the path of the image
   * @param name - the name of the image
   */
  private void load(String path, String name) throws IllegalArgumentException, IOException {
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
  private void save(String path, String name) throws IOException {
    Image image;
    try {
      image = getImage(name);
    } catch (NoSuchObjectException e) {
      throw new RuntimeException(e.getMessage());
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

  private void check3Input(String[] commands) throws IllegalArgumentException {
    if (commands.length < 3) {
      throw new IllegalArgumentException("Invalid number of arguments for " + commands[0]);
    }
  }

  private void check4Input(String[] commands) throws IllegalArgumentException {
    if (commands.length < 4) {
      throw new IllegalArgumentException("Invalid number of arguments for " + commands[0]);
    }
  }

  private void check5Input(String[] commands) throws IllegalArgumentException {
    if (commands.length < 5) {
      throw new IllegalArgumentException("Invalid number of arguments for " + commands[0]);
    }
  }

  private String checkFilePath(String[] commands) throws IllegalArgumentException {
    StringBuilder filePath = new StringBuilder(commands[1]);
    if (commands.length > 3) {
      // Concatenate parts after index 1 to get the complete file path
      for (int i = 2; i < commands.length; i++) {
        filePath.append(" ").append(commands[i]);
      }
    }
    return filePath.toString();
  }


}
