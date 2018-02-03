package TRONv2.tronv2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Picture {

	private static Map<String, BufferedImage> cache = new HashMap<String, BufferedImage>();

	public static void draw(final Graphics g, final String filepath, final int x, final int y) {
		try {
			BufferedImage img;
			if (cache.containsKey(filepath)) {
				img = cache.get(filepath);
			} else {
				img = ImageIO.read(new File(filepath));
				cache.put(filepath, img);
			}
			g.drawImage(img, x, y, null);
		} catch (final IOException e) {
			System.err.println(e.getMessage());
		}
	}

}