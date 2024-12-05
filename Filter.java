/**
 * Filter is an abstract superclass for all image filters in this
 * application. Filters can be applied to OFImages by invoking the apply 
 * method.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Filter {
    public static void main(String[] args) {
        try {
            BufferedImage inputImage = ImageIO.read(new File("input.jpg"));

            ImageIO.write(RedChannelFilter.apply(inputImage), "jpg", new File("red_channel.jpg"));
            ImageIO.write(RedTintFilter.apply(inputImage), "jpg", new File("red_tint.jpg"));
            ImageIO.write(WarholFilter.apply(inputImage), "jpg", new File("warhol.jpg"));
            ImageIO.write(FlippedWarholFilter.apply(inputImage), "jpg", new File("flipped_warhol.jpg"));

            System.out.println("Filters applied and saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

