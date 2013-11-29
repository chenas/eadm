package com.eshop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.base.framwork.domain.BaseModel;

@Entity(name="ONE_ENTITY")
public class OneEntityModel extends BaseModel {
	
	private String name;

	private Set<ManyEntityModel> manyEntity = new HashSet<ManyEntityModel>();
	
	@OneToMany(fetch=FetchType.EAGER)  @OrderBy("name")
	@JoinColumn(name="one_entity_id")
	public Set<ManyEntityModel> getManyEntity() {
		return manyEntity;
	}

	public void setManyEntity(Set<ManyEntityModel> manyEntity) {
		this.manyEntity = manyEntity;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
