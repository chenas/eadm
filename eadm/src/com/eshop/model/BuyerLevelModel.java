package com.eshop.model;
import com.base.framwork.domain.BaseModel;
import javax.*;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *  @author supriseli
   email:supriseli007@gmail.com
 */
@Entity(name="BUYER_LEVEL")
public class BuyerLevelModel extends BaseModel{

	//等级名称
	private String name;
	//等级描述
	private String description;
	//折扣
	private double discount;

	@Column(name="name", length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description", length=100,nullable=true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="discount", length=10,nullable=true)
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}