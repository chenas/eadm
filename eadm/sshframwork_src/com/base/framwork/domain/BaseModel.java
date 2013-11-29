package com.base.framwork.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

/**
 * 所有model的基类
 * @author chenas
 *2013��08��11��
 */
@MappedSuperclass
public class BaseModel extends BaseObject implements IBizDomain{
	
	//主键
	public String id;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@Column(name="ID", length=64, nullable=false)
	@Override
	public String getId() {
		return id;
	}

	/**
	 * 创建者
	 */
	public String createUser;
	
	@Column(name="create_user",length=15)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 创建时间
	 */
	public String createTime;
	
	@Column(name="create_time",length=20)
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 更新时间
	 */
	public String updateTime;

	@Column(name="update_time", length=20)
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * true if the two Objects have tested equals
	 */
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
