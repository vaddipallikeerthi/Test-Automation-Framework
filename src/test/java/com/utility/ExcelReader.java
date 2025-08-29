package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReader {
	
	public static Iterator<User> readExcelFile(String fileName)  {
		XSSFSheet xssfsheet;
		Row row;
		Cell firstCell;
		Cell secondCell;
		
		File xlsxFile=new File(System.getProperty("user.dir")+"//testData//"+fileName);

		XSSFWorkbook xssfworkbook = null;
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> userList=new ArrayList<User>();
		
		 xssfsheet=xssfworkbook.getSheet("LoginData");
		Iterator<Row> rowIterator=xssfsheet.iterator();
		rowIterator.next();
		while(rowIterator.hasNext())
		{
			row=rowIterator.next();
			firstCell = row.getCell(0);

			String emailAddress = "";
			if (firstCell != null) {
			    emailAddress = firstCell.toString().trim();
			}
			
			
			secondCell=row.getCell(1);
			String password="";
			if (secondCell != null) {
			    password = secondCell.toString().trim();
			}
			
			User user=new User(emailAddress,password);
			userList.add(user);
			System.out.println(userList);
		}
		
		try {
			xssfworkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
		
		
		
		
	}

}
