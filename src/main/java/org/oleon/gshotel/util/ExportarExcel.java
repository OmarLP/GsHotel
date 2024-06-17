
package org.oleon.gshotel.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportarExcel {
        public void exportarExcel() throws FileNotFoundException, IOException {
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Creating a blank Excel sheet
        XSSFSheet sheet = workbook.createSheet("student Details");
        // Creating an empty TreeMap of string and Object][] type
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        // Writing data to Object[]
        // using put() method
        data.put("1", new Object[]{"ID", "CITY", "STATE"});
        data.put("2", new Object[]{1, "Clanton", "Alabama"});
        data.put("3", new Object[]{2, "Cordova", "Alaska"});
        data.put("4", new Object[]{3, "Clifton", "Arizona"});
        data.put("5", new Object[]{4, "Arcadia", "California"});

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // Creating a new row in the sheet
            XSSFRow row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // This line creates a cell in the next column of that row
                XSSFCell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }

        //resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //resp.setHeader("Content-Disposition", "attachment; filename=gfgcontribute.xlsx");
        //workbook.write(resp.getOutputStream());
        //Writing the workbook
        FileOutputStream out = new FileOutputStream("gfgcontribute.xlsx");
        workbook.write(out);

        // Closing file output connections
        workbook.close();
    }
}
