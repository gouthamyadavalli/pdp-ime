import org.junit.Test;

import model.impl.ImageFilter;
import model.impl.ImageIOLoader;
import model.impl.ImageIOSaver;
import model.impl.PPMImageLoader;
import model.impl.PPMImageSaver;
import model.impl.RGBImageProcessor;
import model.intf.Image;

public class ImageTest {
  @Test
  public void imageTest(){
    Image testImage = new PPMImageLoader().loadImage("/Users/goutham/Sem1/PDP/projects/pdp-ime/images/pngNew.ppm","test");
    Image flipImage = new RGBImageProcessor().applyFilter(testImage,"h-test", ImageFilter.getSharpenFilter());

//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getBlurFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());

    new ImageIOSaver().saveImage(flipImage, "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/h-test2.png","png");
  }

}
