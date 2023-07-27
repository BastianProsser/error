package a.b.c.repositories;

import org.springframework.data.repository.CrudRepository;

import a.b.c.domain.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{
	 
}