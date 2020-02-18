/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */
package git.lunf.optimizer;

import git.lunf.data.cuttree.CutNode;
import git.lunf.data.cuttree.CutTreeNode;
import git.lunf.data.cuttree.FreeNode;
import git.lunf.model.Dimension;
import git.lunf.model.Layout;
import git.lunf.model.PanelInstance;
import git.lunf.model.Project;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rmuehlba
 */
public abstract class AbstractOptimizationStrategy implements OptimizationStrategy {

    protected FreeNode findSheet(@NonNull final OptimizationResult result,
            @NonNull final PanelInstance p) {

        return getFreeNodes(result).stream()
                .filter(a -> a.canHold(p))
                .findFirst()
                .orElse(null);
    }

    protected List<FreeNode> getFreeNodes(@NonNull final OptimizationResult result) {
        final List<FreeNode> free = new ArrayList<>();
        for (Layout layout : result.getLayouts()) {
            for (CutTreeNode n : layout.getCutTree()) {
                if (n instanceof FreeNode) {
                    free.add((FreeNode) n);
                }
            }
        }
        return free;
    }

    protected FreeNode cutToFit(@NonNull FreeNode candidate,
            @NonNull final Project project,
            @NonNull final PanelInstance p) {

        final Dimension panelDimension = p.getDimension();
        if (candidate.getDimension().getLength() != panelDimension.getLength()) {
            final CutNode cut = candidate.cut(project.getBladeWidth(), panelDimension.getLength(), CutNode.Direction.VERTICAL);
            candidate = (FreeNode) cut.getTarget();
            assert (candidate.getDimension().getLength() == panelDimension.getLength()) : "cut made incorrect length: " + panelDimension.getLength() + " / " + candidate.getDimension().getLength();
        }

        if (candidate.getDimension().getWidth() != panelDimension.getWidth()) {

            final CutNode cut = candidate.cut(project.getBladeWidth(), panelDimension.getWidth(), CutNode.Direction.HORIZONTAL);
            candidate = (FreeNode) cut.getTarget();
            assert (candidate.getDimension().getWidth() == panelDimension.getWidth());
        }
        return candidate;
    }

    protected boolean almostSameSize(final double a, final double b) {
        final double epsilon = 0.1;
        return Math.abs(a - b) < epsilon;
    }
}
