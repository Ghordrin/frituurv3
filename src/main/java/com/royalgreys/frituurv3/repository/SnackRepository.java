package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Snack;

import javax.transaction.Transactional;

@Transactional
public interface SnackRepository extends ProductRepository<Snack>
{

}
