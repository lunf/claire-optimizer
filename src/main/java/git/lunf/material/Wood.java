/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.material;

import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @author rmuehlba
 */
@ToString
public class Wood extends Material implements Serializable {
    private String name;

    public Wood(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
