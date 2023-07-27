package a.b.c.upload;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import a.b.c.domain.Product;
import a.b.c.repositories.ProductRepository;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent>{

	private ProductRepository productRepository;
	
	private Logger log = LogManager.getLogger();

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	};

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Product shirt = new Product();
		shirt.setDescription("Spring polera");
		shirt.setPrice(new BigDecimal("104334.23222"));
		shirt.setProductId("23");
		
		productRepository.save(shirt);
		
		log.info("saved" + shirt.getId());
		
		
		
	};
	
	
	
	
	
}