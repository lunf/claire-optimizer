/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.optimizer;

import git.lunf.errors.OptimizationFailedException;
import git.lunf.model.Project;
import lombok.NonNull;

/**
 *
 * @author rmuehlba
 */
public interface OptimizationStrategy {
    OptimizationResult optimize(@NonNull Project project, @NonNull FitnessFunction fitness) throws OptimizationFailedException;
}
