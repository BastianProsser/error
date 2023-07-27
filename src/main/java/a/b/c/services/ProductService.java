package a.b.c.services;

import a.b.c.domain.Product;


public interface ProductService {
	
	Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);
	
	Product saveProduct(Product product);
	

}
