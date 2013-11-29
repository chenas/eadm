package com.eshop.service.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

/**
 * 操作excel
 * @author chenas
 *
 */
@Component
public class ExcelService implements IExcelService{
	
	public static String  DEFULT_PATH = "C:/eshop/excel";

	/**
	 * 获得excel文件对象
	 * @param file
	 * 						文件对象
	 * @return
	 * 				Workbook
	 */
	public Workbook getWorkbook(File file){
		String path = file.getAbsolutePath();
		return this.getWorkbook(path);
	}
	
	/**
	 * 获得excel文件对象
	 * @param filePath
	 * @return
	 * 				Workbook
	 */
	@Override
	public Workbook getWorkbook(String filePath) {
		//创建文件输入流对象
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//创建 POI文件系统对象
		try {
			 wb = WorkbookFactory.create(is);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	/**
	 * 获得excel文件对象
	 * @param fileInputStream
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Override
	public Workbook getWorkbook(FileInputStream fileInputStream) throws InvalidFormatException, IOException{
		Workbook wb = WorkbookFactory.create(fileInputStream);
		return wb;
	}
	
	/**
	 * 获得工作簿对象
	 * @param sheetNum
	 * 					从零开始
	 * @return
	 * 				Sheet
	 */
	@Override
	public Sheet getSheet(String filePath, int sheetNum) {
		return getWorkbook(filePath).getSheetAt(sheetNum);
	}

	/**
	 * 获得输入流中excel文件的第一个工作簿
	 * @param fileInputStreams
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Override
	public List<Sheet> sheetList(List<FileInputStream> fileInputStreams) throws InvalidFormatException, IOException{
		if(null == fileInputStreams){
			return null;
		}
		List<Sheet> sheets = new ArrayList<Sheet>();
		for(int i=0; i<fileInputStreams.size(); i++){
			sheets.add(getWorkbook(fileInputStreams.get(i)).getSheetAt(0));
		}
		return sheets;
	}
	
	/**
	 * 获取double类型值
	 * @param cell
	 * @return
	 */
	@Override
	public double getDoubleValue(Cell cell) {
		if(null == cell){
			return 0;
		}
		if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
			if(null == cell.getStringCellValue() || "".equals(cell.getStringCellValue())){
				return 0;
			}
			return Double.valueOf(cell.getStringCellValue());
		}else{
			return cell.getNumericCellValue();
		}
	}

	/**
	 * 获取int类型值
	 * @param cell
	 * @return
	 */
	@Override
	public int getIntValue(Cell cell) {
		if(null == cell){
			return 0;
		}
		if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
			if(null == cell.getStringCellValue() || "".equals(cell.getStringCellValue())){
				return 0;
			}
			return Integer.valueOf(cell.getStringCellValue());
		}else{
			return Integer.valueOf((int) cell.getNumericCellValue());
		}
	}
	
	/**
	 * 获取String类型值
	 * @param cell
	 * @return
	 */
	@Override
	public String getStrValue(Cell cell) {
		if(null == cell){
			return "";
		}
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
			return String.valueOf(getIntValue(cell));
		}
		if(null == cell.getStringCellValue() || "".equals(cell.getStringCellValue())){
			return "";
		}
		return cell.getStringCellValue();
	}

	/**
	 * 获得文件输入流
	 * @param folderPath
	 * 							文件夹路径，空时则为默认路径
	 * @return
	 * @throws FileNotFoundException
	 */
	@Override
	public List<FileInputStream> fileInputStreams(String folderPath) throws FileNotFoundException{
		List<FileInputStream> files = new ArrayList<FileInputStream>();
		File file = null;
		if(null == folderPath || "".equals(folderPath)){
			folderPath = DEFULT_PATH;
		}
		file = new File(folderPath);
		String[] fileNames = file.list();
		for(int i=0; i<fileNames.length-1; i++){
			files.add(new FileInputStream(folderPath+"/"+fileNames[i]));
		}
		return files;
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException{
		ExcelService excelService = new ExcelService();
		System.out.println(excelService.sheetList(excelService.fileInputStreams(null)).size());
	}
}
