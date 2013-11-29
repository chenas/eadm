package com.eshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 广告
 * 
 * @author Administrator
 * 
 */
@Entity(name = "ADVERTISEMENT")
public class AdvertisementModel extends BaseModel {
	// 广告内容
	private String content;
	// 广告图片
	private String imageurl;
	// 开始时间
	private Date adBegin;
	// 结束时间
	private Date adEnd;
	// 是否在首页显示 1是，0否
	private String isIndex;

	@Column(name = "is_index", length = 1)
	public String getIsIndex() {
		return isIndex;
	}

	@Column(name = "content", length = 400)
	public String getContent() {
		return content;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return imageurl;
	}

	@Column(name = "ad_begin")
	public Date getAdBegin() {
		return adBegin;
	}

	@Column(name = "ad_end")
	public Date getAdEnd() {
		return adEnd;
	}

	public void setIsIndex(String isIndex) {
		this.isIndex = isIndex;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public void setAdBegin(Date adBegin) {
		this.adBegin = adBegin;
	}

	public void setAdEnd(Date adEnd) {
		this.adEnd = adEnd;
	}

}
