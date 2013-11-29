package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 商品评论
 * @author Administrator 评论
 * 
 */
@Entity(name = "PRODUCT_COMMENT")
public class ProductCommentModel extends BaseModel {
	/**
	 * 对应buyer的id
	 * 
	 */
	private String buyerId;
	/**
	 * 对应product的id
	 */
	private String productId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 星级评价
	 */
	private int starlevel;

	@Column(name = "buyer_id", length = 64)
	public String getBuyerId() {
		return buyerId;
	}

	@Column(name = "product_id", length = 64)
	public String getProductId() {
		return productId;
	}

	@Column(name = "title", length = 50, nullable = false)
	public String getTitle() {
		return title;
	}

	@Column(name = "content", length = 100, nullable = false)
	public String getContent() {
		return content;
	}

	@Column(name = "starlevel")
	public int getStarlevel() {
		return starlevel;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setStarlevel(int starlevel) {
		this.starlevel = starlevel;
	}

}
