package controller.impl;

import static java.lang.Integer.parseInt;

import controller.intf.CommandExecutor;
import model.impl.ImageModelImpl;
import model.intf.Image;
import model.intf.ImageModel;

public class CommandExecutorImpl implements CommandExecutor {

  private ImageModel imageModel;

  public CommandExecutorImpl() {
    imageModel = new ImageModelImpl();
  }

  @Override
  public boolean executeCommand(String[] commands) {
    String command = commands[0].toLowerCase();
    Image image;
    Image[] splitImages = new Image[3];
    try {
      switch (command) {
        case "exit":
          return true;
        case "load":
          imageModel.load(commands[1], commands[2]);
          break;
        case "save":
          imageModel.save(commands[1], commands[2]);
          break;
        case "brighten":
          image = imageModel.brighten(parseInt(commands[1]), commands[2], commands[3]);
          break;
        case "blur":
          image = imageModel.blur(commands[1], commands[2]);
          break;
        case "sharpen":
          image = imageModel.sharpen(commands[1], commands[2]);
          break;
        case "horizontal-flip":
          image = imageModel.horizontalFlip(commands[1], commands[2]);
          break;
        case "vertical-flip":
          image = imageModel.verticalFlip(commands[1], commands[2]);
          break;
        case "sepia":
          image = imageModel.sepia(commands[1], commands[2]);
          break;
        case "greyscale":
          image = imageModel.greyscale(commands[1], commands[2]);
          break;
        case "red-component":
          image = imageModel.getRedComponent(commands[1], commands[2]);
          break;
        case "green-component":
          image = imageModel.getGreenComponent(commands[1], commands[2]);
          break;
        case "blue-component":
          image = imageModel.getBlueComponent(commands[1], commands[2]);
          break;
        case "value-component":
          image = imageModel.getValueComponent(commands[1], commands[2]);
          break;
        case "intensity-component":
          image = imageModel.getIntensityComponent(commands[1], commands[2]);
          break;
        case "luma-component":
          image = imageModel.getLumaComponent(commands[1], commands[2]);
          break;
        case "rgb-split":
          splitImages = imageModel.RGBSplit(commands[1], commands[2], commands[3], commands[4]);
          break;
        case "rgb-combine":
          image = imageModel.getRGBCombined(commands[1], commands[2], commands[3], commands[4]);
          break;
        default:
          throw new IllegalArgumentException("Invalid command");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

}
