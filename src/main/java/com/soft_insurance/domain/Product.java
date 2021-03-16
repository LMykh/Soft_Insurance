package com.soft_insurance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")

public class Product  {
    @PrimaryKey
    private UUID id;
    @Column
    private String product_name;
    @Column
    private String description;
    @Column
    private BigDecimal price;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }






    public Product(UUID id, String name, String description, BigDecimal price) {
        this.id = id;
        this.product_name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
        id = UUID.randomUUID();
    }

}
