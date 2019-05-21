package anruoxin.itc.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/***
 *      ┌─┐       ┌─┐
 *   ┌──┘ ┴───────┘ ┴──┐
 *   │                 │
 *   │       ───       │
 *   │  ─┬┘       └┬─  │
 *   │                 │
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘
 *                神兽保佑
 *               代码无BUG!
 * @author anruoxin
 * @date 2019/5/20 17:26
*/
public class JpgFactory implements PictureFactory{

	public Picture readImg(File file) {
		 if (file == null){
	            return null;
	        }
	        try {
	            Picture picture = new Picture();
	            picture.setName(file.getName());
	            BufferedImage image = ImageIO.read(file);
	            int height = image.getHeight();
	            picture.setHeight(height);
	            int width = image.getWidth();
	            picture.setWidth(width);
	            int minX = image.getMinX();
	            int minY = image.getMinY();
	            Picture.RGB[][] color = new Picture.RGB[height - minY][width - minX];
	            for (int i = minY; i <  height; i ++){
	                for (int j = minX; j < width; j ++){
	                    int colorVal = image.getRGB(j, i);
	                    int r = (colorVal & 0xff0000) >> 16;
	                    int g = (colorVal & 0xff00) >> 8;
	                    int b = (colorVal & 0xff);
	                    Picture.RGB rgb = new Picture.RGB(r, g, b);
	                    color[i - minY][j - minX] = rgb;
	                    //System.out.println("rgb: " + r + "," + g + "," + b);
	                }
	            }
	            picture.setColor(color);
	            return picture;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	}

 
}
