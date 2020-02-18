/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.optimizer;

import lombok.NonNull;

/**
 *
 * @author rmuehlba
 */
public class SimpleFitnessFunction implements FitnessFunction {

    @Override
    public double fitness(@NonNull OptimizationResultStats stats) {
        return /*stats.getBoundingBoxArea() * */ Math.sqrt(stats.getSheetArea()) * stats.getTotalCutLength() / 1e4;
    }
}
