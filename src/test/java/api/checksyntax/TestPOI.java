package api.checksyntax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import api.utilities.ExcelUtility;

public class TestPOI {

	public static void main(String[] args) throws IOException {
		ExcelUtility ul = new ExcelUtility("/Users/anantatimalsina/eclipse-workspace/PetStoreAutomation/testdata/PetData.xlsx");
		int rowCount = ul.getRowCount("Sheet 1");
		int colCount = ul.getCellCount("Sheet 1", 1);
		String sheetData [][] = new String [rowCount-1][colCount];
		System.out.println(sheetData.length);
		
		for(int i=0; i<rowCount-1; i++) {
			for(int j=0; j<colCount; j++) {
				sheetData[i][j] = ul.getCellData("Sheet 1", i+1, j);
				System.out.print(ul.getCellData("Sheet 1", i+1, j));
				System.out.print("|");
			}
			System.out.println("-");
		}
		

	}

}
