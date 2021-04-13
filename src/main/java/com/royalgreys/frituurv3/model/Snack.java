package com.royalgreys.frituurv3.model;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "snack")
@DiscriminatorValue("snack")
@DiscriminatorOptions(force = true)
public class Snack extends Product implements Serializable {

}
