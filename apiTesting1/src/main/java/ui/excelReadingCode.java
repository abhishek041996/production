package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadingCode {
	public static void main(String[] args) {
        String filePath = "D:\\down\\abhiConsumption.xlsx";

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the first sheet
            Sheet sheet =workbook.getSheetAt(0);

            System.out.println("Meter_id\tEnergy\tNickName");
            // Skip the header (row 0)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Retrieve each column value
                String meterId = row.getCell(0)!= null ? row.getCell(0).toString() : "";
                String energy = row.getCell(1)!= null ? row.getCell(1).toString() : "";
                String nickName = row.getCell(2)!= null ? row.getCell(2).toString() : "";

                // Print the values
                System.out.println(meterId + "\t" + energy + "\t" + nickName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
