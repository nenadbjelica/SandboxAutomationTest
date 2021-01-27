package sandbox.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;

	public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
		// create an object of File class to open xls file
		File file = new File(excelFilePath);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		// creating workbook instance that refers to .xls file
		workbook = new XSSFWorkbook(inputStream);
		// creating a Sheet object
		sheet = workbook.getSheet(sheetName);

	}

	public static String getCellData(int rowNumber, int cellNumber) {
		// getting the cell value from rowNumber and cellNumber
		cell = sheet.getRow(rowNumber).getCell(cellNumber);
		// returning the cell value as string
		return cell.getStringCellValue();
	}

}