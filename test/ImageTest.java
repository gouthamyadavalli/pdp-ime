import org.junit.Test;

import model.ImageData;

public class ImageTest {
  @Test
  public void testImage(){
    ImageData img = new ImageData();

    int[][] image = img.readImage("/Users/goutham/Sem1/PDP/projects/pdp-ime/images/manhattan-small.png");

    for(int i=0; i<image.length; i++){
      for(int j = 0; j<image[0].length; j++){
        System.out.print(image[i][j]);
      }
      System.out.println();
    }


  }

  @Test
  public void testFlow(){
    ImageData img = new ImageData();

    int[][] image = img.readImage("/Users/goutham/Sem1/PDP/projects/pdp-ime/images/test.png");

    int[][][] rgb = img.splitRGB(image);

    img.saveImage(rgb[0], "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/test-red.png");
    img.saveImage(rgb[1], "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/test-green.png");
    img.saveImage(rgb[2], "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/test-blue.png");

    int[][] comb = img.combineRGB(rgb[0], rgb[1], rgb[2]);

    img.saveImage(comb,  "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/test-comb.png");
  }
}
