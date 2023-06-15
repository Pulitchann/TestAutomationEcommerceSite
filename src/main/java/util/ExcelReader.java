package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	// Global Variables
	private String path;
	private FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	// Constructor to initialize variables
	public ExcelReader(String path) {
		this.setPath(path);
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) {
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);
		int colNum = 0;
		sheet = workbook.getSheetAt(index);

		// For Row
		XSSFRow row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				colNum = i;
			}
		}

		// For Column
		row = sheet.getRow(rowNum - 1);
		XSSFCell cell = row.getCell(colNum);


		// ------------------------------------
		if (cell.getCellTypeEnum() == CellType.STRING)
			return cell.getStringCellValue();
		else if (cell.getCellTypeEnum() == CellType.NUMERIC)
			return String.valueOf(cell.getNumericCellValue());
		else
			return null;
		// -------------------------------------

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
