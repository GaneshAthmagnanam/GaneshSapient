package com.globomart.productcatalogue.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.productcatalogue.bean.ProductCatalogueBean;
import com.globomart.productcatalogue.customexception.MyResourceNotFoundException;
import com.globomart.productcatalogue.service.ProductCatalogueService;

/**
 * Controller Class where all the user request mapped with the corresponding uri 
 * @author ganesh.athmagnanam
 *
 */

@RestController
public class ProductCatalogueController {

	@Autowired
	ProductCatalogueService myService;
	
	/**
	 * Method to fetch/retrieve the list of products, GET Opertaion
	 * 		based on simple search criteria e.g. product type
	 * @param type pathVariable -Product Type
	 * @return List of ProductCatalogueBean Object
	 */
	@RequestMapping("/product/fetchProduct/{productType}")
	public Map<String, List<ProductCatalogueBean>> fetchProducts(@PathVariable("productType") String type) {
		List<ProductCatalogueBean> listObject = new ArrayList<>();
		Map<String, List<ProductCatalogueBean>> mappedProductCatalogueBeanDetails = new LinkedHashMap<>();
		listObject = myService.fetch(type);
		if(listObject.isEmpty()){
			throw new MyResourceNotFoundException("Product "+type+ " doesnt exist.");
		}
		mappedProductCatalogueBeanDetails.put("Product Types of " + type, listObject);

		return mappedProductCatalogueBeanDetails;
	}

	/**
	 * Method to add a product, POST operation.
	 * @param bean- ProductCatalogueBean
	 * @return List of String- Response Message
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/product/addProduct")
	public List<String> addProduct(@Valid @RequestBody ProductCatalogueBean bean)  {
		List<String> msgInJsonAddProduct= new ArrayList<>();
		String addProductMessage=null;
		addProductMessage = myService.addCatalogueProduct(bean);
		msgInJsonAddProduct.add(addProductMessage);
		return msgInJsonAddProduct;

	}
	
	/**
	 * Method to removeProduct from catalogue
	 * @param id- Represents primary key object which has to be removed
	 * @return List of String- Response message
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="/product/deleteProduct/{productId}")
	public List<String> deleteProduct(@PathVariable("productId") long id) {
		List<String> msgInJsonRemoveProduct= new ArrayList<>();
		String removeProductMessage=null;
		removeProductMessage = myService.deleteCatalogueProduct(id);
		msgInJsonRemoveProduct.add(removeProductMessage);
		return msgInJsonRemoveProduct;
		
	}

}
