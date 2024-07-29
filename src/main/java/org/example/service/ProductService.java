package org.example.service;

import org.example.dao.ProductReposiroty;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    final private ProductReposiroty reposiroty;

    public ProductService(ProductReposiroty reposiroty) {
        this.reposiroty = reposiroty;
    }

    public Boolean addProduct(Product product){
//        return reposiroty.onboardProduct(product.getCustomerid(), product.getProduct())==1;
        return reposiroty.save(product).getProductid() > 0;

    }
}
