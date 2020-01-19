package bitmap.transform;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Bitmap {

    File bitPic;
    File nextBitPic;
    String nextName;

    public Bitmap (String inputPath, String outputPath, String newName) {
        this.bitPic = new File(inputPath);
        this.nextBitPic = new File(outputPath + "/" + newName);
        this.nextName = newName;
    }

    public void sourcedFile (BufferedImage eightBitImage) {
        try {

            ImageIO.write(eightBitImage, "bmp", this.nextBitPic);

        } catch (IOException e) {
            System.out.println("Error at bitOutputFile method");
            e.printStackTrace();
        }
    }

    // Color invert
    // Credit: Anna
    public Bitmap colorInvert() {

        try {
            BufferedImage originalBMP = ImageIO.read(this.bitPic);

            for (int i=0; i <originalBMP.getHeight(); i++) {
                for (int j=0; j <originalBMP.getWidth(); j++) {

                    Color bitColor = new Color(originalBMP.getRGB(i,j));

                    int red = (255 - bitColor.getRed());
                    int green = (255 - bitColor.getGreen());
                    int blue = (255 - bitColor.getBlue());

                    Color newBitColor = new Color(red, green, blue);

                    originalBMP.setRGB(i,j,newBitColor.getRGB());

                }
            }
            this.sourcedFile(originalBMP);

        } catch (IOException e) {
            System.out.println("Error at colorInvert method");
            e.printStackTrace();
        }

        return null;
    }

    // Randomize Color/TV Static
    // Credit: https://www.educative.io/edpresso/how-to-use-the-mathrandom-method-in-java
    public Bitmap colorRandomize(String nextName) {

        try {
            BufferedImage receivedImage = ImageIO.read(this.bitPic);

            for (int i=0; i <receivedImage.getHeight(); i++) {
                for (int j=0; j <receivedImage.getWidth(); j++) {

                    Random color = new Random();
                    int low = 1;
                    int high = 255;
                    int randomRGB = color.nextInt(high-low) + low;

                    Color newBitColor = new Color(randomRGB, randomRGB, randomRGB);

                    receivedImage.setRGB(i,j,newBitColor.getRGB());

                }
            }

            this.sourcedFile(receivedImage);

        } catch (IOException e) {
            System.out.println("Error at colorRandomize method");
            e.printStackTrace();
        }

        return null;
    }

    // Watermark
    // Credit: Graphics2D - https://www.codejava.net/java-se/graphics/adding-a-watermark-over-an-image-programmatically-using-java
    static void markBMPWithWater(String bitPic, String nextName, String nextBitPic) {

        try {
            BufferedImage sourceImage = ImageIO.read(new File(bitPic));

            // Initiate Graphics2D
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

            // Set transparency
            AlphaComposite waterMarkIntegrity = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            g2d.setComposite(waterMarkIntegrity);

            // Set text properties
            g2d.setColor(Color.CYAN);
            g2d.setFont(new Font("Verdana", Font.BOLD, 20));

            // Get parameters from Graphics2D for putting text on top of an image
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D box = fontMetrics.getStringBounds(nextName, g2d);

            // Set where you want the text to display
            int centerX = (sourceImage.getWidth() - (int) box.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2;
            g2d.drawString(nextName, centerX, centerY);

            // Add the watermark and send as new file
            ImageIO.write(sourceImage, "BMP", new File(nextBitPic));

            // Disconnect from Graphics2D
            g2d.dispose();

        } catch (IOException ex) {
            System.out.println("Error at markBMPWithWater method");
            ex.printStackTrace();
        }
    }
}

