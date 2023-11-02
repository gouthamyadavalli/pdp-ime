package controller.impl;

import controller.intf.ImageLoaderSaver;
import java.io.IOException;
import model.impl.RGBImage;
import model.intf.Image;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractLoaderSaverUtilTest {

  @Test
  public void testLoadImage() throws IOException {
    int[][] red = {{255, 0, 0}, {0, 0, 15}, {0, 0, 0}};
    int[][] green = {{0, 213, 0}, {0, 0, 0}, {102, 0, 0}};
    int[][] blue = {{0, 111, 0}, {43, 0, 0}, {0, 0, 89}};
    Image image = new RGBImage("test-image", 3, 3, red, green, blue);
    getImageLoaderSaver().saveImage(image, getImagePath(), getImageType());
    Image loadedImage = getImageLoaderSaver().loadImage(getImagePath(), getImageName());
    Assert.assertEquals(image, loadedImage);
  }

  protected abstract ImageLoaderSaver getImageLoaderSaver();

  protected abstract String getImagePath();

  protected abstract String getImageName();

  protected abstract String getImageType();

}
