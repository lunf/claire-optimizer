/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.optimizer;

import lombok.NonNull;

/**
 *
 * @author rmuehlba
 */
@FunctionalInterface
public interface FitnessFunction {
    public double fitness(@NonNull final OptimizationResultStats result);
}
