package social.benji.benjipersonservice.person.application;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public  class ImageUtil {

    public static byte[] thumbnail(MultipartFile file) throws IOException {
        int newWidth = 200;

        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();
        int newHeight = (int) (height * ((float) newWidth / (float) width));
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        resizedImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        ByteArrayOutputStream bass = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", bass);
        return bass.toByteArray();

    }
}
