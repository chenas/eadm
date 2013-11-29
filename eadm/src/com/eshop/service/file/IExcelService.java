package com.eshop.service.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 操作excel表格接口
 * @author chenas
 *
 */
public interface IExcelService {

	/**
	 * 获得excel文件对象
	 * @param file
	 * 						文件对象
	 * @return
	 * 				Workbook
	 */
	public Workbook getWorkbook(File file);
	
	/**
	 * 获得excel文件对象
	 * @param filePath
	 * 						文件路径
	 * @return
	 * 				Workbook
	 */
	public Workbook getWorkbook(String filePath);

	/**
	 * 获得excel文件对象
	 * @param fileInputStream
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public Workbook getWorkbook(FileInputStream fileInputStream) throws InvalidFormatException, IOException;
	
	/**
	 * 
	 * 获得工作簿对象
	 * @param filePath
	 * 						文件路径
	 * @param sheetNum
	 * 						从零开始
	 * @return
	 * 				Sheet
	 */
	public Sheet getSheet(String filePath, int sheetNum);

	/**
	 * 获得输入流中excel文件的第一个工作簿
	 * @param fileInputStreams
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public List<Sheet> sheetList(List<FileInputStream> fileInputStreams) throws InvalidFormatException, IOException;
	
	/**
	 * 获得行对象
	 * @param rowNum
	 * 					从零开始
	 * @return
	 * 					Row
	 */
//	public Row getRow(int rowNum);
	
	/**
	 * 获得指定格对象
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * 					Cell
	 */
//	public Cell getCell(int rowNum, int cellNum);
	
	/**
	 * 获取double类型值
	 * @param cell
	 * @return
	 */
	public double getDoubleValue(Cell cell);
	
	/**
	 * 获取int类型值
	 * @param cell
	 * @return
	 */
	public int getIntValue(Cell cell);
	
	/**
	 * 获取String类型值
	 * @param cell
	 * @return
	 */
	public String getStrValue(Cell cell);
	
	/**
	 * 获得文件输入流
	 * @param folderPath
	 * 							文件夹路径，空时则为默认路径
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<FileInputStream> fileInputStreams(String folderPath) throws FileNotFoundException;
	
}
