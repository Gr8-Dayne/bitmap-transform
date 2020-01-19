package bitmap.transform;


import static org.junit.Assert.*;
import org.junit.Test;


public class AppTest {


    @Test public void testInitialGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.initialGreeting());
    }


//    @Test public void testHappy() {
//        int width = 640;
//        int height = 480;
//
//        App bbs = new App(width, height);
//        bbs.fill(Color.CYAN);
//        bbs.setPixel(width / 2, height / 2, Color.BLACK);
//        Color c1 = bbs.getPixel(width / 2, height / 2);
//        Color c2 = bbs.getPixel(20, 20);
//
//        assertEquals(Color.BLACK, c1);
//        assertEquals(Color.CYAN, c2);
//    }

}
