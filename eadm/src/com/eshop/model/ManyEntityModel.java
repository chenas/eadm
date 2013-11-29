package com.eshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.base.framwork.domain.BaseModel;

@Entity(name = "MANY_ENTITY")
public class ManyEntityModel extends BaseModel {

	private String name;

	private OneEntityModel oneEntityModel;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "one_entity_id", updatable = false)
	public OneEntityModel getOneEntityModel() {
		return oneEntityModel;
	}

	public void setOneEntityModel(OneEntityModel oneEntityModel) {
		this.oneEntityModel = oneEntityModel;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
