package com.royalgreys.frituurv3.model;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "burger")
@DiscriminatorValue("burger")
@DiscriminatorOptions(force = true)
public class Burger extends Product implements Serializable {

}
