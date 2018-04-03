package com.globomart.productcatalogue.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * ORM Bean Class
 * @author ganesh.athmagnanam
 *
 */
@Entity
public class ProductCatalogueBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productNo;
	@Column(nullable=false)
	private String productName;
	@Column(nullable=false)
	private String productType;
	@Column(nullable=false)
	private float price;
	@Column(nullable=false)
	private String description;
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
