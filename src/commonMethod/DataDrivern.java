package commonMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivern {
	public static ArrayList<String> getdata(String testSheetName, String testCaseName) throws IOException {
		ArrayList<String> dataArray = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\11\\Desktop\\testdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int coutofsheet = workbook.getNumberOfSheets();

		for (int i = 0; i < coutofsheet; i++) {
			String sheetName = workbook.getSheetName(i);

			if (sheetName.equalsIgnoreCase(testSheetName))

			{
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row nextrow = rows.next();

				Iterator<Cell> cells = nextrow.cellIterator();

				int j = 0;
				int tc_column = 0;

				while (cells.hasNext()) {
					Cell datacell = cells.next();

					if (datacell.getStringCellValue().equalsIgnoreCase("tc_name")) {
						tc_column = j;
					}
					j++;

				}
				while (rows.hasNext()) {
					Row datarow = rows.next();
					{
						if (datarow.getCell(tc_column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
							Iterator<Cell> dataofCell = datarow.cellIterator();

							while (dataofCell.hasNext()) {
								Cell cellValue = dataofCell.next();

								try {
									String testdata = cellValue.getStringCellValue();
									dataArray.add(testdata);
								} catch (IllegalStateException e) {
									int intdata = (int) cellValue.getNumericCellValue();
									String strdata = Integer.toString(intdata);
									dataArray.add(strdata);

								}
							}

						}
					}
				}

			}

		}
		return dataArray;

	}

}
