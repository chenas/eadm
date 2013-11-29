package com.eshop.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.service.file.IExcelService;

public class TestExcelService {

	IExcelService excelService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		excelService = (IExcelService) ctx.getBean("excelService");
	}
	
	@Test
	public void testGetWorkBook(){
		String filePath = "E:\\QinZhu\\oldVersion\\勤助商店资料\\校名电子商务\\校名商品信息更新.xlsx";
		Workbook wb = excelService.getWorkbook(filePath);
		Sheet sh = wb.getSheetAt(0);
		Row row = sh.getRow(0);
		System.out.println(row.getCell(0).getStringCellValue());
		System.out.println(wb);
	}
	
	public void testSheetList() throws InvalidFormatException, FileNotFoundException, IOException{
		String folderPath = "E:/excel";
		List<Sheet> sheets = excelService.sheetList(excelService.fileInputStreams(null));
		System.out.println(sheets.size());
	}
	
	
}
