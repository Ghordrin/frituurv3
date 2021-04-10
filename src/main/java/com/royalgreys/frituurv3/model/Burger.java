package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("3")
public class Burger extends Product implements Serializable {


}
