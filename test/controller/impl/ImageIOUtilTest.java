package controller.impl;

import controller.intf.ImageLoaderSaver;
import org.junit.Before;

public class ImageIOUtilTest extends AbstractLoaderSaverUtilTest {

  private ImageIOUtil imageIOUtil;

  @Before
  public void setUp() {
    imageIOUtil = new ImageIOUtil();
  }


  @Override
  protected ImageLoaderSaver getImageLoaderSaver() {
    return imageIOUtil;
  }

  @Override
  protected String getImagePath() {
    return "images/test-image.png";
  }

  @Override
  protected String getImageName() {
    return "test-image";
  }

  @Override
  protected String getImageType() {
    return "png";
  }
}
