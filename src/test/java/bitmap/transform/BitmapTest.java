package bitmap.transform;


import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;


public class BitmapTest {

    @Test public void testSourcedFile() throws IOException {

        String destination = "src/main/resources/itsAMe.bmp";
        Bitmap someBit = new Bitmap("src/main/resources/itsAMe.bmp", "src/main/resources/", "notLuigi.bmp");
        BufferedImage someBuffIm = ImageIO.read(someBit.bitPic);
        someBit.sourcedFile(someBuffIm);
        File outputBit = new File(destination);
        boolean exists = outputBit.exists();
        assertTrue("There's gotta be something", exists);

    }
}


