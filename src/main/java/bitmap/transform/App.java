package bitmap.transform;


public class App {
    
    public String initialGreeting() {
        return "Bitmap? More like struggle.";
    }

    public static void main(String[] args) {

        System.out.println(new App().initialGreeting());

        String inputBMP = "src/main/resources/itsAMe.bmp";
        String outputPath = "src/main/resources/";

        Bitmap tryout = new Bitmap(inputBMP, outputPath, "meAIts.bmp");

        tryout.colorInvert();
        System.out.println("Color invert complete");

        tryout = new Bitmap(inputBMP, outputPath, "tvStatic.bmp");

        tryout.colorRandomize("tvStatic.bmp");
        System.out.println("Color randomize complete");

        tryout.markBMPWithWater("src/main/resources/itsAMe.bmp", "yeet", "src/main/resources/itsAyeet.bmp");
        System.out.println("Watermark complete");

    }

}