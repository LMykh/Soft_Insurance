package com.soft_insurance.controller;

import java.util.List;
import java.util.UUID;

import com.soft_insurance.domain.Product;
import com.soft_insurance.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/catalog/products/")
public class ProductController {
   @Autowired
     ProductService productService;

    //GET by ID
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getById(@PathVariable("id") UUID productId) {
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = this.productService.getById(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //putch

    @PatchMapping (value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> patchProductById(@PathVariable UUID id, @RequestBody Product product) {
        Product patchProduct = productService.getById(id);
        if(product.getProduct_name()!=null){
            patchProduct.setProduct_name(product.getProduct_name());
        }
        if(product.getDescription()!=null){
            patchProduct.setDescription(product.getDescription());
        }
        if(product.getPrice() != null){
            patchProduct.setPrice(product.getPrice());
        }
        productService.save(patchProduct);
        return new ResponseEntity<>(patchProduct, HttpStatus.OK);
    }

    @PostMapping(value = "/packagecontent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findProductsByIds(@RequestBody List<UUID> uuidList) {
        return new ResponseEntity<>(productService.findProductsByIds(uuidList),HttpStatus.OK);
    }

    //PUT
    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //DELETE by ID
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Product> deleteById(@PathVariable UUID id) {
        Product product = this.productService.getById(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.productService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //GET All
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.productService.getAllProducts();

        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}






