package a.b.c.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.domain.Product;
import a.b.c.services.ProductService;

@Controller
public class ProductController {
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/products", method= RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("product", productService.listAllProducts());
		System.out.println("Retorno de productos: ");
		
		return "products";
	}
	
	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		
		model.addAttribute("product", productService.getProductById(id));
		
		return "productsShow";
		
	} 
	
	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		
		model.addAttribute("product", productService.getProductById(id));
		
		return "productform";
		
	} 
	
	@RequestMapping("product/new")
	public String newProduct(Model model) {
		
		model.addAttribute("product", new Product());
		return "productform";
		
	}
	
	@RequestMapping(value="product", method= RequestMethod.POST)
	public String saveProduct(Product product) {
		
		productService.saveProduct(product);
		
		return "redirect:/product/" + product.getId();
		
	}
	
}
