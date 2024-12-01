package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public XSSFWorkbook excelWorkBook;
	public XSSFSheet workSheet;
	public XSSFRow row ;
	public XSSFCell cell;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		excelWorkBook = new XSSFWorkbook(fi);
		workSheet = excelWorkBook.getSheet(sheetName);
		int rowCount = workSheet.getLastRowNum();
		excelWorkBook.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		excelWorkBook = new XSSFWorkbook(fi);
		workSheet = excelWorkBook.getSheet(sheetName);
		row = workSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		excelWorkBook.close();
		fi.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int cellNumber) throws IOException {
		fi = new FileInputStream(path);
		excelWorkBook = new XSSFWorkbook(fi);
		workSheet = excelWorkBook.getSheet(sheetName);
		row = workSheet.getRow(rowNum);
		cell = row.getCell(cellNumber);
		
		DataFormatter formatter = new DataFormatter();
		String cellData;
		
		cellData = formatter.formatCellValue(cell);
		
		excelWorkBook.close();
		fi.close();
		return cellData;
		
	}
	
	
	
	
	

	}

