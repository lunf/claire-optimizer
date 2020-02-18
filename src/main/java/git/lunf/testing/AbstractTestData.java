/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.testing;


import git.lunf.material.Wood;
import git.lunf.model.Dimension;
import git.lunf.model.Panel;
import git.lunf.model.Project;
import git.lunf.model.StockSheet;
import lombok.NonNull;

import java.util.List;

/**
 *
 * @author rmuehlba
 */
public abstract class AbstractTestData implements TestData {

    public Project makeProject(@NonNull List<Panel> inputs, final int bladeWidth) {
        Project project = new Project();
        project.setPanels(inputs);
        project.setBladeWidth(bladeWidth);
        return project;
    }
   
    protected StockSheet makeSheet(double length, double width) {
        return new StockSheet("wood", new Wood("wood"), new Dimension(length, width), 18, false);
    }
}
