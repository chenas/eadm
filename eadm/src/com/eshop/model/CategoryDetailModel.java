package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 二级分类
 * 
 * @author Administrator
 * 
 */
@Entity(name = "CATEGORY_DETAIL")
public class CategoryDetailModel extends BaseModel {

	/**
 * 
 */
	private String name;
	/**
 * 
 */
	private String description;

	private String categoryId;

	@Column(name = "name", length = 20, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "category_id", length = 64, nullable = false)
	public String getCategoryId() {
		return categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
