package com.soft_insurance.repository;

import com.soft_insurance.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductRepository extends CrudRepository<Product, Serializable > {
}
