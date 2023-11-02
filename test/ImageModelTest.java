import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.impl.RGBImage;
import model.impl.RGBImageModelImpl;
import model.intf.Image;
import model.intf.ImageModel;

public class ImageModelTest {

  private RGBImageModelImpl imageModel;
  private Image testImage;

  @Before
  public void setUp() {
    imageModel = new RGBImageModelImpl();
    // Create a 4x3 test image for each test case
    int[][] red = {{255, 0, 100}, {50, 200, 150}, {30, 90, 120}, {180, 60, 220}};
    int[][] green = {{0, 255, 50}, {100, 150, 200}, {70, 110, 160}, {240, 30, 130}};
    int[][] blue = {{100, 50, 255}, {180, 70, 120}, {140, 190, 220}, {80, 160, 210}};
    testImage = new RGBImage("Test Image", 4, 3, red, green, blue);
  }

  @Test
  public void testBrighten() {
    Image brightenedImage = imageModel.brighten(testImage, 50, "Brightened Image");

    int[][] expectedRed = {{255, 50, 150}, {100, 250, 200}, {80, 140, 170}, {230, 110, 255}};
    int[][] expectedGreen = {{50, 255, 100}, {150, 200, 250}, {120, 160, 210}, {255, 80, 180}};
    int[][] expectedBlue = {{150, 100, 255}, {230, 120, 170}, {190, 240, 255}, {130, 210, 255}};

    for (int i = 0; i < brightenedImage.getWidth(); i++) {
      for (int j = 0; j < brightenedImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], brightenedImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], brightenedImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], brightenedImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void test_brighten_positive_factor() {
    ImageModel imageModel = new RGBImageModelImpl();
    Image image = new RGBImage("Test Image", 3, 3,
            new int[][]{{100, 50, 200}, {20, 80, 110}, {40, 150, 100}},
            new int[][]{{200, 20, 120}, {60, 100, 150}, {80, 130, 180}},
            new int[][]{{30, 110, 160}, {90, 130, 190}, {120, 160, 220}});
    Image brightenedImage = imageModel.brighten(image, 50, "Brightened Image");

    int[][] expectedRed = {{150, 100, 250}, {70, 130, 160}, {90, 200, 150}};
    int[][] expectedGreen = {{250, 70, 170}, {110, 150, 200}, {130, 180, 230}};
    int[][] expectedBlue = {{80, 160, 210}, {140, 180, 240}, {170, 210, 255}};

    for (int i = 0; i < brightenedImage.getWidth(); i++) {
      for (int j = 0; j < brightenedImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], brightenedImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], brightenedImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], brightenedImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testBrightenNegative() {
    ImageModel imageModel = new RGBImageModelImpl();
    Image image = new RGBImage("Test Image", 3, 3,
            new int[][]{{100, 50, 200}, {20, 80, 110}, {40, 150, 100}},
            new int[][]{{200, 20, 120}, {60, 100, 150}, {80, 130, 180}},
            new int[][]{{30, 110, 160}, {90, 130, 190}, {120, 160, 220}});
    Image darkenedImage = imageModel.brighten(image, -50, "Darkened Image");

    int[][] expectedRed = {{50, 0, 150}, {0, 30, 60}, {0, 100, 50}};
    int[][] expectedGreen = {{150, 0, 70}, {10, 50, 100}, {30, 80, 130}};
    int[][] expectedBlue = {{0, 60, 110}, {40, 80, 140}, {70, 110, 170}};

    for (int i = 0; i < darkenedImage.getWidth(); i++) {
      for (int j = 0; j < darkenedImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], darkenedImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], darkenedImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], darkenedImage.getBlue(i, j));
      }
    }
  }
  @Test
  public void testVerticalFlip() {
    Image flippedImage = imageModel.verticalFlip(testImage, "Horizontal Flipped Image");

    int[][] expectedRed = {{100, 0, 255}, {150, 200, 50}, {120, 90, 30}, {220, 60, 180}};
    int[][] expectedGreen = {{50, 255, 0}, {200, 150, 100}, {160, 110, 70}, {130, 30, 240}};
    int[][] expectedBlue = {{255, 50, 100}, {120, 70, 180}, {220, 190, 140}, {210, 160, 80}};

    for (int i = 0; i < flippedImage.getWidth(); i++) {
      for (int j = 0; j < flippedImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], flippedImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], flippedImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], flippedImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testValueComponent() {
    ImageModel imageModel = new RGBImageModelImpl();
    Image inputImage = new RGBImage("Input Image", 3, 3,
            new int[][]{{100, 150, 200}, {50, 100, 150}, {200, 150, 100}},
            new int[][]{{200, 200, 100}, {150, 100, 200}, {100, 200, 0}},
            new int[][]{{0, 50, 100}, {200, 200, 150}, {100, 150, 200}});
    Image resultImage = imageModel.getValueComponent(inputImage, "Value Component Image");
    int[][] expectedRed = {{200, 200, 200}, {200, 200, 200}, {200, 200, 200}};
    int[][] expectedGreen = {{200, 200, 200}, {200, 200, 200}, {200, 200, 200}};
    int[][] expectedBlue = {{200, 200, 200}, {200, 200, 200}, {200, 200, 200}};
    for (int i = 0; i < resultImage.getWidth(); i++) {
      for (int j = 0; j < resultImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], resultImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], resultImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], resultImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testIntensityComponent() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{100, 150, 200}, {50, 100, 150}, {0, 50, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {50, 100, 150}, {100, 150, 200}});

    Image intensityImage = new RGBImageModelImpl().getIntensityComponent(inputImage, "Intensity Image");

    for (int i = 0; i < intensityImage.getWidth(); i++) {
      for (int j = 0; j < intensityImage.getHeight(); j++) {
        int average = (inputImage.getRed(i, j) + inputImage.getGreen(i, j) + inputImage.getBlue(i, j)) / 3;
        Assert.assertEquals(average, intensityImage.getRed(i, j));
        Assert.assertEquals(average, intensityImage.getGreen(i, j));
        Assert.assertEquals(average, intensityImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testLumaComponent() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{100, 150, 200}, {50, 100, 150}, {200, 150, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 150, 200}},
            new int[][]{{150, 100, 50}, {100, 50, 0}, {50, 0, 100}});

    Image lumaImage = imageModel.getLumaComponent(inputImage, "Luma Image");

    for (int i = 0; i < lumaImage.getWidth(); i++) {
      for (int j = 0; j < lumaImage.getHeight(); j++) {
        int expectedValue = (int) (0.2126 * inputImage.getRed(i, j) + 0.7152 * inputImage.getGreen(i, j) + 0.0722 * inputImage.getBlue(i, j));
        Assert.assertEquals(expectedValue, lumaImage.getRed(i, j));
        Assert.assertEquals(expectedValue, lumaImage.getGreen(i, j));
        Assert.assertEquals(expectedValue, lumaImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testRedComponent() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
            new int[][]{{19, 20, 21}, {22, 23, 24}, {25, 26, 27}});

    Image redComponentImage = new RGBImage("Red Component Image", 3, 3, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});

    Image result = new RGBImageModelImpl().getRedComponent(inputImage, "Red Component Image");

    for (int i = 0; i < redComponentImage.getWidth(); i++) {
      for (int j = 0; j < redComponentImage.getHeight(); j++) {
        Assert.assertEquals(redComponentImage.getRed(i, j), result.getRed(i, j));
        Assert.assertEquals(redComponentImage.getGreen(i, j), result.getGreen(i, j));
        Assert.assertEquals(redComponentImage.getBlue(i, j), result.getBlue(i, j));
      }
    }
  }

  @Test
  public void testGreenComponent() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
            new int[][]{{19, 20, 21}, {22, 23, 24}, {25, 26, 27}});

    Image greenComponentImage = new RGBImageModelImpl().getGreenComponent(inputImage, "Green Component Image");

    for (int i = 0; i < greenComponentImage.getWidth(); i++) {
      for (int j = 0; j < greenComponentImage.getHeight(); j++) {
        Assert.assertEquals(inputImage.getGreen(i, j), greenComponentImage.getGreen(i, j));
        Assert.assertEquals(0, greenComponentImage.getRed(i, j));
        Assert.assertEquals(0, greenComponentImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testBlueComponent() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{100, 150, 200}, {50, 100, 150}, {0, 50, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {50, 100, 150}, {100, 150, 200}});
    Image blueComponentImage = imageModel.getBlueComponent(inputImage, "Blue Component Image");

    for (int i = 0; i < inputImage.getWidth(); i++) {
      for (int j = 0; j < inputImage.getHeight(); j++) {
        Assert.assertEquals(inputImage.getBlue(i, j), blueComponentImage.getBlue(i, j));
        Assert.assertEquals(0, blueComponentImage.getRed(i, j));
        Assert.assertEquals(0, blueComponentImage.getGreen(i, j));
      }
    }
  }

  @Test
  public void testSepiaTransformation() {
    Image inputImage = new RGBImage("Input Image", 3, 3, new int[][]{{100, 150, 200}, {50, 100, 150}, {200, 150, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {100, 150, 200}, {200, 150, 100}});

    Image sepiaImage = imageModel.sepia(inputImage, "Sepia Image");

    int[][] expectedRed = {{193, 183, 174}, {153, 144, 135}, {193, 125, 58}};
    int[][] expectedGreen = {{193, 183, 174}, {153, 144, 135}, {193, 125, 58}};
    int[][] expectedBlue = {{193, 183, 174}, {153, 144, 135}, {193, 125, 58}};

    for (int i = 0; i < sepiaImage.getWidth(); i++) {
      for (int j = 0; j < sepiaImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], sepiaImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], sepiaImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], sepiaImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testGreyscaleTransformation() {
    ImageModel imageModel = new RGBImageModelImpl();
    Image image = new RGBImage("Test Image", 3, 3, new int[][]{{100, 150, 200}, {50, 100, 150}, {0, 50, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {50, 100, 150}, {100, 150, 200}});
    Image greyscaleImage = imageModel.greyscale(image, "Greyscale Image");

    int[][] expectedGrey = {{164, 142, 121}, {121, 100, 78}, {78, 57, 35}};


    for (int i = 0; i < greyscaleImage.getWidth(); i++) {
      for (int j = 0; j < greyscaleImage.getHeight(); j++) {
        Assert.assertEquals(expectedGrey[i][j], greyscaleImage.getRed(i, j));
        Assert.assertEquals(expectedGrey[i][j], greyscaleImage.getGreen(i, j));
        Assert.assertEquals(expectedGrey[i][j], greyscaleImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testRGBCombine() {
    Image red = new RGBImage("Red", 3, 3,
            new int[][]{{100, 100, 100}, {100, 100, 100}, {100, 100, 100}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    Image green = new RGBImage("Green", 3, 3,
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            new int[][]{{100, 100, 100}, {100, 100, 100}, {100, 100, 100}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    Image blue = new RGBImage("Blue", 3, 3,
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            new int[][]{{100, 100, 100}, {100, 100, 100}, {100, 100, 100}});

    Image result = new RGBImageModelImpl().getRGBCombined("Combined", red, green, blue);

    int[][] expectedRed = {{100, 100, 100}, {100, 100, 100}, {100, 100, 100}};
    int[][] expectedGreen = {{100, 100, 100}, {100, 100, 100}, {100, 100, 100}};
    int[][] expectedBlue = {{100, 100, 100}, {100, 100, 100}, {100, 100, 100}};

    Image expectedImage = new RGBImage("Comb", 3, 3, expectedRed, expectedGreen, expectedBlue);

    for (int i = 0; i < result.getWidth(); i++) {
      for (int j = 0; j < result.getHeight(); j++) {
        Assert.assertEquals(expectedImage.getRed(i, j), result.getRed(i, j));
        Assert.assertEquals(expectedImage.getGreen(i, j), result.getGreen(i, j));
        Assert.assertEquals(expectedImage.getBlue(i, j), result.getBlue(i, j));
      }
    }
  }

  @Test
  public void testRGBSplit() {
    Image inputImage = new RGBImage("Input Image", 3, 3,
            new int[][]{{100, 150, 200}, {50, 100, 150}, {200, 150, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {100, 150, 200}, {200, 150, 100}});

    Image[] splitImages = imageModel.getRGBSplit(inputImage, "Red", "Green", "Blue");

    int[][] expectedRed = {{100, 150, 200}, {50, 100, 150}, {200, 150, 100}};
    int[][] expectedGreen = {{200, 150, 100}, {150, 100, 50}, {100, 50, 0}};
    int[][] expectedBlue = {{0, 50, 100}, {100, 150, 200}, {200, 150, 100}};

    for (int i = 0; i < splitImages[0].getWidth(); i++) {
      for (int j = 0; j < splitImages[0].getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], splitImages[0].getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], splitImages[1].getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], splitImages[2].getBlue(i, j));
      }
    }
  }

  @Test
  public void testHorizontalFlip() {
    Image flippedImage = imageModel.horizontalFlip(testImage, "Vertical Flipped Image");

    int[][] expectedRed = {{180, 60, 220}, {30, 90, 120}, {50, 200, 150}, {255, 0, 100}};
    int[][] expectedGreen = {{240, 30, 130}, {70, 110, 160}, {100, 150, 200}, {0, 255, 50}};
    int[][] expectedBlue = {{80, 160, 210}, {140, 190, 220}, {180, 70, 120}, {100, 50, 255}};

    for (int i = 0; i < flippedImage.getWidth(); i++) {
      for (int j = 0; j < flippedImage.getHeight(); j++) {
        Assert.assertEquals(expectedRed[i][j], flippedImage.getRed(i, j));
        Assert.assertEquals(expectedGreen[i][j], flippedImage.getGreen(i, j));
        Assert.assertEquals(expectedBlue[i][j], flippedImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testGetValueComponent() {
    Image valueComponentImage = imageModel.getValueComponent(testImage, "Value Component Image");

    int[][] expectedValueComponent = {
            {255, 255, 255},
            {180, 200, 200},
            {140, 190, 220},
            {240, 160, 220}
    };
    for (int i = 0; i < valueComponentImage.getWidth(); i++) {
      for (int j = 0; j < valueComponentImage.getHeight(); j++) {
        Assert.assertEquals(expectedValueComponent[i][j], valueComponentImage.getRed(i, j));
        Assert.assertEquals(expectedValueComponent[i][j], valueComponentImage.getGreen(i, j));
        Assert.assertEquals(expectedValueComponent[i][j], valueComponentImage.getBlue(i, j));
      }
    }
  }

  @Test
  public void testSplitCombine(){
    Image inputImage = new RGBImage("Input Image", 3, 3,
            new int[][]{{100, 150, 200}, {50, 100, 150}, {200, 150, 100}},
            new int[][]{{200, 150, 100}, {150, 100, 50}, {100, 50, 0}},
            new int[][]{{0, 50, 100}, {100, 150, 200}, {200, 150, 100}});

    Image[] splitImages = imageModel.getRGBSplit(inputImage, "Red", "Green", "Blue");
  }
}
