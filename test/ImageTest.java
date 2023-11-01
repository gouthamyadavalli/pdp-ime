import controller.impl.ImageIOUtil;
import controller.impl.PPMImageUtil;
import model.impl.ImageFilter;
import model.impl.RGBImageModelImpl;
import model.intf.Image;
import org.junit.Test;

public class ImageTest {

  @Test
  public void imageTest() {
    Image testImage = new PPMImageUtil().loadImage(
        "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/pngNew.ppm", "test");
    Image flipImage = new RGBImageModelImpl().applyFilter(testImage, "h-test",
        ImageFilter.getSharpenFilter());

//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getBlurFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());
//    flipImage = new RGBImageProcessor().applyFilter(flipImage,"h-test", ImageFilter.getSharpenFilter());

    new ImageIOUtil().saveImage(flipImage,
        "/Users/goutham/Sem1/PDP/projects/pdp-ime/images/h-test2.png", "png");
  }

}
