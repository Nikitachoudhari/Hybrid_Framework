package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws Throwable {

		ExcelFileUtil excel = new ExcelFileUtil("./testData/Login_Data.xlsx");

		int totalRow = excel.rowcount("Sheet1");
		int totalColumn = excel.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRow][totalColumn];

		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalColumn; j++) {
				loginData[i][j] = excel.getCellData("sheet1", i, j);
			}
		}

		return loginData;
	}

}
