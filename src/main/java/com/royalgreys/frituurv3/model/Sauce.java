package com.royalgreys.frituurv3.model;

import com.sun.source.doctree.SerialDataTree;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity

public class Sauce extends Product implements Serializable {
}
