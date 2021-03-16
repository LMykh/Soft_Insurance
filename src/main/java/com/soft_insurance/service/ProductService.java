package com.soft_insurance.service;
import java.util.List;
import java.util.UUID;
import com.soft_insurance.domain.Product;

public interface ProductService {

    Product getById(UUID id);


    void save(Product product);

    void delete(UUID id);

    List<Product> getAllProducts();
    List<Product> findProductsByIds(List<UUID> ids);

}

