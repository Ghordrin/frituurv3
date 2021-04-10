package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public List<Product> findAll();

}
