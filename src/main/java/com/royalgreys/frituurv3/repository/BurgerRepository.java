package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Burger;

import javax.transaction.Transactional;

@Transactional
public interface BurgerRepository extends ProductRepository<Burger> {
}
