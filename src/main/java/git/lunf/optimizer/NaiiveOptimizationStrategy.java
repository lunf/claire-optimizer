/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.optimizer;

import git.lunf.data.cuttree.FreeNode;
import git.lunf.model.PanelInstance;
import git.lunf.model.Project;
import lombok.NonNull;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author rmuehlba
 */
public class NaiiveOptimizationStrategy extends AbstractOptimizationStrategy {

    private final static Logger log = Logger.getLogger(NaiiveOptimizationStrategy.class.getName());

    @Override
    public OptimizationResult optimize(@NonNull final Project project, @NonNull final FitnessFunction fitness) {

        OptimizationResult optimizationResult = new OptimizationResult();

        List<PanelInstance> panels = project.getPanelInstances().stream()
                .sorted((b, a) -> Double.compare(a.getDimension().getLength(), b.getDimension().getLength()))
                .collect(Collectors.toList());

        for (PanelInstance p : panels) {
            FreeNode candidate = findSheet(optimizationResult, p);
            if (candidate == null) {
                optimizationResult.createNewLayout(p);
                candidate = findSheet(optimizationResult, p);
            }

            candidate = cutToFit(candidate, project, p);
            candidate.setPanel(p);
        }

        return optimizationResult;
    }
}
