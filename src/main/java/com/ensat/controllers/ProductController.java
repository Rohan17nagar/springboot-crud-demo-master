package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController("/")
// @RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productService.listAllProducts();
		return products;
	}

	@GetMapping("/getProductById/{id}")
	public Product showProduct(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		return product;
	}

	@PutMapping("/updateProductById/{id}")
	public Product edit(@PathVariable Integer id, @RequestBody Product product) {

		Product updatedProduct = productService.updateProduct(id, product);

		return updatedProduct;
	}

	@PostMapping("/addProduct")
	public Product newProduct(@RequestBody Product model) {

		Product entireProduct = productService.saveProduct(model);

		System.out.println(entireProduct);

		return entireProduct;
	}

	@PostMapping("/addProducts")
	public Product saveProduct(Product product) {
		return product;
	}

	@DeleteMapping("deleteProductById/{id}")
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "Product deleted successfully.";
	}

	@DeleteMapping("deleteAllProducts")
	public String deleteAllProducts() {
		productService.deleteAllProduct();
		return "All Products deleted.";
	}
}
