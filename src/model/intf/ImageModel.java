package model.intf;

public interface ImageModel {

  void load(String path, String name);

  void save(String path, String name);

  Image[] RGBSplit(String name, String redName, String greenName, String blueName);


  Image brighten(int factor, String name, String newName);

  Image blur(String name, String newName);

  Image sharpen(String name, String newName);

  Image getValueComponent(String name, String newName);

  Image getIntensityComponent(String name, String newName);

  Image getLumaComponent(String name, String newName);

  Image horizontalFlip(String name, String newName);

  Image verticalFlip(String name, String newName);

  Image sepia(String name, String newName);

  Image greyscale(String name, String newName);

  Image getRedComponent(String name, String newName);

  Image getGreenComponent(String name, String newName);

  Image getBlueComponent(String name, String newName);

  Image getRGBCombined(String newName, String redName, String greenName, String blueName);

}
