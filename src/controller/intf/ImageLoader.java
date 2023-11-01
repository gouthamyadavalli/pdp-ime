package controller.intf;

import model.intf.Image;

public interface ImageLoader {
  Image loadImage(String path, String name);

  void saveImage(Image image, String path, String type);

}
