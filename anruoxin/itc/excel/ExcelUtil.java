package anruoxin.itc.excel;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import anruoxin.itc.img.Picture;

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

    public static void getImgExcelWithXLSX(Picture picture){
        XSSFWorkbook wookbook = new XSSFWorkbook();
        
        if (picture == null) {
            System.out.println("获取图片失败");
            return;
        }
        XSSFSheet sheet = wookbook.createSheet(picture.getName().replaceAll("\\.\\w+", ""));
        Picture.RGB[][] color = picture.getColor();
        CellStyle style = wookbook.createCellStyle();
//        XSSFColor tabColor = sheet.getTabColor();
//        tabColor.setRGB(new byte[]{0,0,0});
//        System.out.println("yanse:" + tabColor.getIndex());
//        tabColor.setRGB(new byte[]{(byte) 255,(byte) 255,(byte) 255});
//        System.out.println("yanse:" + tabColor.getIndex());
        System.out.println(picture.getHeight() + ", " + picture.getWidth());
        for (int i = 0; i < picture.getHeight(); i ++){
            XSSFRow row = sheet.createRow(i);
            
            for(int j = 0; j < picture.getWidth(); j ++){
            	
                XSSFCell cell = row.createCell(j);
              DefaultIndexedColorMap defaultIndexedColorMap = new DefaultIndexedColorMap();
              XSSFColor xssfColor = new XSSFColor(defaultIndexedColorMap);
              xssfColor.setRGB(new byte[] {
            		  (byte) color[i][j].getR(), (byte) color[i][j].getG(), (byte) color[i][j].getB()
              });

                cell.setCellValue("1");
                //style.setFillForegroundColor();
                //solid 填充  foreground  前景色
               // style.setFillPattern();
               cell.getSheet().setTabColor(xssfColor);
               cell.setCellStyle(style);

            }
        }
        //保存到本地
        File file = new File("e:/itc_img/test.xlsx");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            wookbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	System.out.println("完成转换");
        }
    }
    public static void getImgExcelWithXLS(Picture picture){
    	HSSFWorkbook workbook = new HSSFWorkbook();
        
        if (picture == null) {
            System.out.println("获取图片失败");
            return;
        }
        HSSFSheet sheet = workbook.createSheet(picture.getName().replaceAll("\\.\\w+", ""));
        Picture.RGB[][] color = picture.getColor();
        CellStyle style = workbook.createCellStyle();

        System.out.println(picture.getHeight() + ", " + picture.getWidth());
        for (int i = 0; i < picture.getHeight(); i ++){
            HSSFRow row = sheet.createRow(i);
            
            for(int j = 0; j < picture.getWidth(); j ++){
            	
                HSSFCell cell = row.createCell(j);
                cell.setCellValue("1");
                style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
            	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	cell.setCellStyle(style);
                HSSFPalette palette = workbook.getCustomPalette();
                System.out.println(color[i][j].getR() +", " +color[i][j].getG() +", "+color[i][j].getB() +", ");
            	palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.RED.getIndex(), (byte) color[i][j].getR(), (byte) color[i][j].getG(), (byte) color[i][j].getB());

            }
        }
        //保存到本地
        File file = new File("e:/itc_img/test.xls");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	System.out.println("完成转换");
        }
    }

    public static void main(String[] args) {
    	HSSFWorkbook wb = new HSSFWorkbook();
    	HSSFSheet sheet = wb.createSheet();
    	HSSFRow row = sheet.createRow((short) 0);
    	HSSFCell cell = row.createCell((short) 0);
    	cell.setCellValue("Default Palette");

    	//apply some colors from the standard palette,
    	// as in the previous examples.
    	//we'll use red text on a lime background

    	HSSFCellStyle style = wb.createCellStyle();
    	style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
    	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    	HSSFFont font = wb.createFont();
    	font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
    	style.setFont(font);

    	cell.setCellStyle(style);

    	//save with the default palette
    	FileOutputStream out = null;
    	try {
    		out = new FileOutputStream("e:/itc_img/default_palette.xls");
			wb.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	//now, let's replace RED and LIME in the palette
    	// with a more attractive combination
    	// (lovingly borrowed from freebsd.org)

    	cell.setCellValue("Modified Palette");

    	//creating a custom palette for the workbook
    	HSSFPalette palette = wb.getCustomPalette();
    	palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.RED.getIndex(), (byte) 255, (byte) 255, (byte) 255);

    	try {
			out = new FileOutputStream("e:/itc_img/modified_palette.xls");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
}