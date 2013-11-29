package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 一级分类
 * 
 * @author Administrator
 * 
 */
@Entity(name = "CATEGORY")
public class CategoryModel extends BaseModel {

	private String name;

	private String description;

	@Column(name = "description", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name", length = 20, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
