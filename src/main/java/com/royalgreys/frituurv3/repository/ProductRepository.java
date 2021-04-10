package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ProductRepository<T extends  Product> extends CrudRepository<T, Integer> {
    public List<T> findAll();

}
