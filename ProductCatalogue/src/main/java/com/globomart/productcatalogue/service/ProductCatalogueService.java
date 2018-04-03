package com.globomart.productcatalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.bean.ProductCatalogueBean;

/**
 * Service Layer to communicate with DB 
 * @author ganesh.athmagnanam
 *
 */
@Service
public class ProductCatalogueService {

	@Autowired
	ProductCatalogueRepository productCatalogue;

	public List<ProductCatalogueBean> fetch(String type) {
		List<ProductCatalogueBean> pbList = new ArrayList<>();
		pbList=productCatalogue.findByproductType(type);
		return pbList;
	}

	public String addCatalogueProduct(ProductCatalogueBean PCBean) {
		String message = null;
		try {
			productCatalogue.save(PCBean);
			message = "Product Added Successfully";
		} catch (Exception e) {
			message = "Failure in transaction... ";
		}
		return message;

	}

	public String deleteCatalogueProduct(long id) {
		String message = null;
		try {
			productCatalogue.delete(id);
			message = "Product Removed Successfully";
		} catch (Exception e) {
			message = "Failure in transaction... ";
		}
		return message;

	}
}
