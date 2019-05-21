package anruoxin.itc.img;


import java.io.File;

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
 * @date 2019/5/20 16:13
*/
public class ImgUtil {
    public static Picture getColor(String filePath){
        JpgFactory jpgFactory = new JpgFactory();
        Picture picture =jpgFactory.readImg(new File(filePath));
        return picture;
    }
    public static void main(String[] args) {
        String filePath = "e:/itc_img/b.jpeg";

    }
}
