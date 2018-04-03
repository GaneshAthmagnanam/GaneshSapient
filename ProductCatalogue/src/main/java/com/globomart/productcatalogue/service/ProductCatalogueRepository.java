package com.globomart.productcatalogue.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globomart.productcatalogue.bean.ProductCatalogueBean;

/**
 * Custom interface which extends JpaRepsoitory interface,
 *  which has in built functions to communicate with the bean class.
 * @author ganesh.athmagnanam
 *
 */
public interface ProductCatalogueRepository
extends JpaRepository<ProductCatalogueBean,Long>{
	
	List<ProductCatalogueBean> findByproductType(String productType);
}
