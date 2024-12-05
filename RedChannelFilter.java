
/**
 * Write a description of class RedChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

public class RedChannelFilter {
    public static BufferedImage apply(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int gray = (red << 16) | (red << 8) | red;
                output.setRGB(x, y, gray);
            }
        }
        return output;
    }
}


