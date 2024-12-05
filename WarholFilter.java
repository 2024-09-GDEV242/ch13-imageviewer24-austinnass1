
/**
 * Write a description of class WarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

public class WarholFilter {
    public static BufferedImage apply(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int quarterWidth = width / 2;
        int quarterHeight = height / 2;

        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = output.createGraphics();

        BufferedImage redTint = RedTintFilter.apply(image);
        BufferedImage greenTint = GreenTintFilter.apply(image);
        BufferedImage blueTint = BlueTintFilter.apply(image);

        g.drawImage(image, 0, 0, quarterWidth, quarterHeight, null);
        g.drawImage(redTint, quarterWidth, 0, quarterWidth, quarterHeight, null);
        g.drawImage(greenTint, 0, quarterHeight, quarterWidth, quarterHeight, null);
        g.drawImage(blueTint, quarterWidth, quarterHeight, quarterWidth, quarterHeight, null);

        g.dispose();
        return output;
    }
}
