package com.soft_insurance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table ("products")
public class Product implements Serializable {
    @PrimaryKey
    private UUID product_id;
    @Column
    private String product_name;
    @Column
    private String description;
    @Column
    private BigDecimal price;


    public UUID getProduct_id() {return product_id;}

    public void setProduct_id(UUID product_id) {this.product_id = product_id;}

    public String getProduct_name() {return product_name;}

    public void setProduct_name(String product_name) {this.product_name = product_name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}



    public Product() {
    }

    public Product(UUID id, String name, String description, BigDecimal price) {
        this.product_id = id;
        this.product_name = name;
        this.description = description;
        this.price = price;
    }

}
