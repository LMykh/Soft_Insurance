package com.soft_insurance.service;

import com.soft_insurance.domain.Product;
import com.soft_insurance.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getById(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(new Product());
    }

    @Override
    public void save(Product product) {
         productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findProductsByIds(List<UUID> ids) {
        return productRepository.findProductsByIdIn(ids);
    }


    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }


}
