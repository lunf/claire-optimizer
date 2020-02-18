/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */
package git.lunf.optimizer;

import git.lunf.data.cuttree.CutTreeStats;
import git.lunf.model.Layout;
import git.lunf.model.PanelInstance;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rmuehlba
 */
@ToString
public class OptimizationResult implements Serializable {

    private final List<Layout> layouts = new ArrayList<>();
    private double runtime;

    public void createNewLayout(@NonNull PanelInstance p) {
        addLayout(new Layout(p.getSheet(), layouts.size()));
    }

    private void addLayout(Layout l) {
        layouts.add(l);
    }

    public OptimizationResultStats getStats() {
        int numberOfCuts = 0;
        int numberOfLayouts = layouts.size();
        double totalCutLength = 0;
        double sheetArea = 0;
        double usedArea = 0;
        double boundingBoxArea = 0;
        for (Layout layout : layouts) {
            CutTreeStats substats = layout.getCutTree().getStats();
            numberOfCuts += substats.getNumberOfCuts();
            totalCutLength += substats.getTotalCutLength();
            sheetArea += substats.getSheetArea();
            usedArea += substats.getUsedArea();
            boundingBoxArea += substats.getBoundingBoxArea();
        }
        OptimizationResultStats stats = new OptimizationResultStats(numberOfLayouts,
                numberOfCuts,
                totalCutLength,
                sheetArea,
                usedArea,
                boundingBoxArea);
        return stats;
    }

    public List<Layout> getLayouts() {
        return layouts;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

}
