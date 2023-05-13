package com.ensat.services;

import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class ProductServiceImpl implements ProductService {
     @Autowired
     private ProductRepository productRepository;

    

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

	@Override
	public Product updateProduct(Integer id, Product product) {

		Product existingProduct = productRepository.findById(id).orElse(null);
		existingProduct.setProductName(product.getProductName());
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
		
	}
	
	

}
