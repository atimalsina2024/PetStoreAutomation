package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class PetDataProvider {
	
	@DataProvider(name="allData")
	public String [][] getAllPetData() throws IOException{
		
		String path = System.getProperty("user.dir") + "/testdata/PetData.xlsx";
		ExcelUtility util = new ExcelUtility(path);
		int rowCount = util.getRowCount("Sheet 1");
		int colCount = util.getCellCount("Sheet 1", 1);
		
		String sheetData [][] = new String [rowCount-1][colCount];
		
		for(int i=0; i<rowCount-1; i++) {
			for(int j=0; j<colCount; j++) {
				sheetData[i][j] = util.getCellData("Sheet 1", i+1, j);
			}
		}
		return sheetData;
		
	}
	
	@DataProvider(name="idData")
	public String [] getAllIds() throws IOException {
		String path = System.getProperty("user.dir") + "/testdata/PetData.xlsx";
		ExcelUtility ul = new ExcelUtility(path);
		
		int rowCount = ul.getRowCount("Sheet 1");
		String [] cellData = new String [rowCount-1];
		for (int i=0; i<rowCount-1; i++) {
			cellData[i] = ul.getCellData("Sheet 1", i+1 , 0);
		}
		return cellData ;
	}

}
