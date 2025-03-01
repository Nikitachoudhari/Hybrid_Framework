package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {

	XSSFWorkbook xw;

	// constructor for reading excel path
	public ExcelFileUtil(String ExcelPath) throws Throwable {
		FileInputStream fi = new FileInputStream(ExcelPath);
		xw = new XSSFWorkbook(fi);
	}

	// Method for counting no of rows in a sheet
	public int rowcount(String sheetname) {
		int count = xw.getSheet(sheetname).getLastRowNum();
		return count;
	}

	// Method for counting no of columns in a row
	public int getCellCount(String sheetName, int row) {
		XSSFSheet sheet = xw.getSheet(sheetName);
		int cellcount = sheet.getRow(row).getLastCellNum();

		return cellcount;
	}

	// method to get data of cell
	public String getCellData(String sheetname, int row, int column) {
		String data;
		if (xw.getSheet(sheetname).getRow(row).getCell(column).getCellType() == CellType.NUMERIC) {
			int cellValue = (int) xw.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data = String.valueOf(cellValue);
		} else {
			data = xw.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}

	// Method to set cell value
	public void setCellData(String sheetname, int row, int column, String status, String writeExcel) throws Throwable {
		XSSFCell xc = xw.getSheet(sheetname).getRow(row).createCell(column);
		xc.setCellValue(status);

		if (status.equalsIgnoreCase("Pass")) {
			XSSFCellStyle style = xw.createCellStyle();
			XSSFFont font = xw.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			xw.getSheet(sheetname).getRow(row).getCell(column).setCellStyle(style);
		} else if (status.equalsIgnoreCase("Fail")) {
			XSSFCellStyle style = xw.createCellStyle();
			XSSFFont font = xw.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			xw.getSheet(sheetname).getRow(row).getCell(column).setCellStyle(style);
		} else if (status.equalsIgnoreCase("Blocked")) {
			XSSFCellStyle style = xw.createCellStyle();
			XSSFFont font = xw.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			xw.getSheet(sheetname).getRow(row).getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(writeExcel);
		xw.write(fo);
	}

}
