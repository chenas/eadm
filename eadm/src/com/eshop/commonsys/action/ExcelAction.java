package com.eshop.commonsys.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.base.framwork.action.BaseAction;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.model.CategoryModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.model.UserShopModel;
import com.eshop.service.ICategoryDetailService;
import com.eshop.service.ICategoryService;
import com.eshop.service.IProductInfoService;
import com.eshop.service.IUserShopService;
import com.eshop.service.file.IExcelService;

/**
 * 上传excel并提取内容
 * @author chenas
 *
 */
public class ExcelAction extends BaseAction {
	
	@Resource
	private IExcelService excelService;

	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private ICategoryService categoryService;
	
	@Resource
	private ICategoryDetailService categoryDetailService;
	
	@Resource
	private IUserShopService userShopService;
	
	private String storeId;
	
	//excel表格
	private File fileExcel;
	private String fileExcelFileName;
	private String fileExcelContentType;

	public String excelContent() throws IOException{
		//得到本工程下的/excels目录
		String targetDir = ServletActionContext.getServletContext().getRealPath("/excel");
		//在指定的目录创建文件
		File target = new File(targetDir, fileExcelFileName);
		//把上传的文件存进项目文件夹
		FileUtils.copyFile(fileExcel, target);
		
		List<ProductInfoModel> productInfoModels = new ArrayList<ProductInfoModel>();
		

		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"美味的食品"+"'");
		CategoryModel c1 = categoryService.findEntityListByFilter(cdf).get(0);
		cdf.setQueryString(" where a.name='"+"好喝的饮品"+"'");
		CategoryModel c2 = categoryService.findEntityListByFilter(cdf).get(0);
		cdf.setQueryString(" where a.name='"+"必备日用品"+"'");
		CategoryModel c3 = categoryService.findEntityListByFilter(cdf).get(0);
		cdf.setQueryString(" where a.name='"+"土豪送的礼品"+"'");
		CategoryModel c4 = categoryService.findEntityListByFilter(cdf).get(0);
		
		UserShopModel shop =  userShopService.findEntityById(storeId);
	System.out.println(shop);
		if(null == shop){
			addActionMessage("该商店不存在！");
			return SUCCESS;
		}
		
		Workbook workbook = excelService.getWorkbook(fileExcel);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		for(int i=1; i<rowNum; i++){
			Row row = sheet.getRow(i);
			ProductInfoModel productInfoModel = new ProductInfoModel();
			//商品编号
			productInfoModel.setProductid(excelService.getStrValue(row.getCell(0)));
			//名称
			productInfoModel.setName(excelService.getStrValue(row.getCell(1)));
			//价格
			productInfoModel.setPrice(excelService.getDoubleValue(row.getCell(2)));
			//进价
			productInfoModel.setInprice(excelService.getDoubleValue(row.getCell(3)));
			//促销价
			productInfoModel.setOnsalePrice(excelService.getDoubleValue(row.getCell(4)));
			//库存
			productInfoModel.setRemainNumber(excelService.getIntValue(row.getCell(5)));
			//图片路径
			productInfoModel.setImageBig(excelService.getStrValue(row.getCell(6)));
			//描述
			productInfoModel.setDescription(excelService.getStrValue(row.getCell(7)));
			//关键词
			productInfoModel.setKeyword(excelService.getStrValue(row.getCell(8)));
			//是否促销
			productInfoModel.setIsOnsale(excelService.getStrValue(row.getCell(11)));
			
			//与一级分类设置关联
			if("美味的食品".equals(excelService.getStrValue(row.getCell(9)).trim())){
				productInfoModel.setCategoryId(c1.getId());
			}else if("好喝的饮品".equals(excelService.getStrValue(row.getCell(9)).trim())){
				productInfoModel.setCategoryId(c2.getId());
				
			}else if("必备日用品".equals(excelService.getStrValue(row.getCell(9)).trim())){
				productInfoModel.setCategoryId(c3.getId());
				
			}else if("土豪送的礼品".equals(excelService.getStrValue(row.getCell(9)).trim())){
				productInfoModel.setCategoryId(c4.getId());
			}
			String c2name = excelService.getStrValue(row.getCell(10)).trim();
			//设置商品的默认状态，不进行促销
			//productInfoModel.setIsOnsale("0");
			//设置商品的默认状态，上架
			productInfoModel.setIsSale("1");
			//设置与二级分类关联
			productInfoModel.setCategoryDetailId(categoryDetailService.getByName(c2name).getId());
			//设置对应的所属商店
			productInfoModel.setShopId(shop.getId());
			
			productInfoModels.add(productInfoModel);
		}
		for(int i=0; i<productInfoModels.size(); i++){
			productInfoService.insertEntity(productInfoModels.get(i), null);
		}
		log.info(workbook);
		return SUCCESS;
	}

	public File getFileExcel() {
		return fileExcel;
	}

	public void setFileExcel(File fileExcel) {
		this.fileExcel = fileExcel;
	}

	public String getFileExcelFileName() {
		return fileExcelFileName;
	}

	public void setFileExcelFileName(String fileExcelFileName) {
		this.fileExcelFileName = fileExcelFileName;
	}

	public String getFileExcelContentType() {
		return fileExcelContentType;
	}

	public void setFileExcelContentType(String fileExcelContentType) {
		this.fileExcelContentType = fileExcelContentType;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
}
