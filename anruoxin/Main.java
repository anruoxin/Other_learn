package anruoxin;

import anruoxin.excel.ExcelUtil;
import anruoxin.img.ImgUtil;
import anruoxin.img.Picture;

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
 * @date 2019/5/20 16:09
*/
public class Main
{
    public static void main( String[] args ) {
        String filePath = "e:/itc_img/d.png";
        Picture picture = ImgUtil.getColor(filePath);
        ExcelUtil.getImgExcel(picture);
    }
}
