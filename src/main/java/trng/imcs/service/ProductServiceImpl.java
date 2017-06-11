package trng.imcs.service;

import trng.imcs.model.Product;

public class ProductServiceImpl implements ProductService {

	public Product getProduct(String productId) {
		return new Product(productId, "Computer", 300);
	}

}
