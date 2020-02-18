/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */
package git.lunf.optimizer;

import git.lunf.data.cuttree.FreeNode;
import git.lunf.model.PanelInstance;
import git.lunf.model.Project;
import io.jenetics.EnumGene;
import io.jenetics.Optimize;
import io.jenetics.engine.Codec;
import io.jenetics.engine.Codecs;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.ISeq;
import lombok.NonNull;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rmuehlba
 */
public class GAOptimizationStrategy extends AbstractOptimizationStrategy {

    private static final Logger log = Logger.getLogger(GAOptimizationStrategy.class.getName());
    public static java.util.Random random = new java.util.Random();

    @Override
    public OptimizationResult optimize(@NonNull final Project project, 
            @NonNull final FitnessFunction fitness) {


        final ISeq<PanelInstance> panels = ISeq.of(project.getPanelInstances());
        final Codec<ISeq<PanelInstance>, EnumGene<PanelInstance>> codec = Codecs.ofPermutation(panels);

        final Engine<EnumGene<PanelInstance>, Double> engine
                = Engine.builder((seq) -> fitness.fitness(optimizeAux(project, seq.asList()).getStats()), codec)
                        .optimize(Optimize.MINIMUM)
                        .build();

        // 4.) Start the execution (evolution) and
        //     collect the result.
        ISeq<PanelInstance> result = codec.decode(
                engine.stream()
                        .limit(120)
                        .collect(EvolutionResult.toBestGenotype()));

        return optimizeAux(project, result.asList());
    }

    public OptimizationResult optimizeAux(@NonNull final Project project, @NonNull final List<PanelInstance> panels) {

        final OptimizationResult optimizationResult = new OptimizationResult();

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
