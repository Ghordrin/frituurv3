package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Sauce;

import javax.transaction.Transactional;

@Transactional
public interface SauceRepository extends ProductRepository<Sauce>{
}
