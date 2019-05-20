package anruoxin.excel;

import anruoxin.img.Picture;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileOutputStream;

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
public class ExcelUtil{

    public static void getImgExcel(Picture picture){
        HSSFWorkbook sheets = new HSSFWorkbook();
        if (picture == null) {
            System.out.println("获取图片失败");
            return;
        }
        HSSFSheet sheet = sheets.createSheet(picture.getName().replaceAll("\\.\\w+", ""));
        Picture.RGB[][] color = picture.getColor();
        CellStyle style = sheets.createCellStyle();
        HSSFPalette palette = sheets.getCustomPalette();
        for (int i = 0; i < picture.getHeight(); i ++){
            HSSFRow row = sheet.createRow(i);
            for(int j = 0; j < picture.getWidth(); j ++){
                HSSFCell cell = row.createCell(j);
                //style.setFillForegroundColor(HSSFColor.LIME.index);
                //solid 填充  foreground  前景色
                //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                //cell.setCellStyle(style);
                palette.setColorAtIndex(HSSFColor.LIME.index,(byte) color[i][j].getR(),(byte) color[i][j].getG(), (byte) color[i][j].getB());

            }
        }
        //保存到本地
        File file = new File("e:/itc_img/test.xls");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            sheets.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) {
//        HSSFWorkbook sheets = new HSSFWorkbook();
//        HSSFSheet sheet = sheets.createSheet("picture");
//        // 样式
//        HSSFCellStyle contentStyle = sheets.createCellStyle();
//
//        //保存到本地
//        File file = new File("e:/itc_img/test.xls");
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            sheets.write(outputStream);
//            outputStream.flush();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }


    }
}