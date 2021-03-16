package com.soft_insurance.repository;

import com.soft_insurance.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {


    List<Product> findProductsByIdIn(List<UUID> ids);
}
