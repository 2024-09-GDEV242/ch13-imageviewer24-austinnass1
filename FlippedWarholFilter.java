
/**
 * Write a description of class FlippedWarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.BufferedImage;

public class FlippedWarholFilter {
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

        // Draw original and flipped images in quadrants
        g.drawImage(image, 0, 0, quarterWidth, quarterHeight, null);
        g.drawImage(flipHorizontally(redTint), quarterWidth, 0, quarterWidth, quarterHeight, null);
        g.drawImage(flipVertically(greenTint), 0, quarterHeight, quarterWidth, quarterHeight, null);
        g.drawImage(flipBoth(blueTint), quarterWidth, quarterHeight, quarterWidth, quarterHeight, null);

        g.dispose();
        return output;
    }

    private static BufferedImage flipHorizontally(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                flipped.setRGB(width - x - 1, y, image.getRGB(x, y));
            }
        }
        return flipped;
    }

    private static BufferedImage flipVertically(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                flipped.setRGB(x, height - y - 1, image.getRGB(x, y));
            }
        }
        return flipped;
    }

    private static BufferedImage flipBoth(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                flipped.setRGB(width - x - 1, height - y - 1, image.getRGB(x, y));
            }
        }
        return flipped;
    }
}
