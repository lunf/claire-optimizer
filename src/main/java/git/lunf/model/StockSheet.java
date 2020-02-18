/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.model;

import git.lunf.material.Material;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;


/**
 *
 * @author rmuehlba
 */
@ToString
public class StockSheet implements Serializable {

    private final Material material;
    private final double thickness;
    private final String title;
    private final Dimension dimension;
    private final boolean grain;


    public StockSheet(@NonNull final String title, 
            @NonNull final Material material, 
            @NonNull final Dimension dimension, 
            final double thickness, final boolean hasGrain) {
        
        this.material = material;
        this.dimension = dimension;
        this.thickness = thickness;
        this.title = title;
        this.grain = hasGrain;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasGrain() {
        return grain;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public double getThickness() {
        return thickness;
    }
}
