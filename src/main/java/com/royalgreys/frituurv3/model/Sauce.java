package com.royalgreys.frituurv3.model;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("sauce")
@DiscriminatorOptions(force = true)
public class Sauce extends Product implements Serializable {
}
