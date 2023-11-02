package controller.impl;

import controller.intf.ImageLoaderSaver;
import org.junit.Before;

public class PPMImageUtilTest extends AbstractLoaderSaverUtilTest{

  private PPMImageUtil ppmImageUtil;

  @Before
  public void setUp() {
    ppmImageUtil = new PPMImageUtil();
  }


  @Override
  protected ImageLoaderSaver getImageLoaderSaver() {
    return ppmImageUtil;
  }

  @Override
  protected String getImagePath() {
    return "images/test-image.ppm";
  }

  @Override
  protected String getImageName() {
    return "test-image";
  }

  @Override
  protected String getImageType() {
    return "ppm";
  }
}
