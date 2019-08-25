package org.snapdeal.excel.test.SnapdealExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String getData(int rowno,int columnno) throws Throwable
	 {
		File loc = new File("G:\\Workspace\\SnapdealExcel\\Excelfile\\Book2.xlsx");
		  FileInputStream f = new FileInputStream(loc);
		  Workbook w = new XSSFWorkbook(f);
		  Sheet s = w.getSheet("Josee");
		  Row r = s.getRow(rowno);
		  Cell c = r.getCell(columnno);
		  int type = c.getCellType();
		  String txtvalue ="";
		  
		  if(type==1)
		  {
			  txtvalue = c.getStringCellValue();
		  }
		  else if(type==0)
		  {
			  double d = c.getNumericCellValue();
			  long l = (long)d;
			  txtvalue = String.valueOf(l);
		  }
		  else
		  {
			  if(DateUtil.isCellDateFormatted(c))
			  {
				  Date d = c.getDateCellValue();
				  SimpleDateFormat frmt = new SimpleDateFormat("dd-MMM-yy");
				  txtvalue = frmt.format(d);
			  }
		  }
		 
		return txtvalue;
	 }
public static void main(String[] args) throws Throwable {
	getData(1,1);
}
}
