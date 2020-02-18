/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.model;

import git.lunf.data.cuttree.CutTree;
import git.lunf.data.cuttree.CutTreeNode;
import git.lunf.data.cuttree.PanelNode;
import lombok.NonNull;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @author rmuehlba
 */
@ToString
public class Layout implements Serializable {

    private final StockSheet sheet;
    private final int id;
    private final CutTree cutTree;

    public Layout(@NonNull final StockSheet sheet, final int id) {
        this.sheet = sheet;
        this.id = id;
        this.cutTree = new CutTree(sheet);
    }

    public StockSheet getSheet() {
        return sheet;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfPlacedPanels() {
        int num = 0;
        for (CutTreeNode node : getCutTree()) {
            if (node instanceof PanelNode) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfSubSheets() {
        int num = 0;
        for (CutTreeNode n : getCutTree()) {
            num++;
        }
        return num;
    }

    public CutTree getCutTree() {
        return cutTree;
    }
}
