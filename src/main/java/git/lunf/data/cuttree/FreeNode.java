/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.data.cuttree;

import git.lunf.model.Dimension;
import git.lunf.model.PanelInstance;
import git.lunf.model.Position;
import lombok.NonNull;

/**
 *
 * @author rmuehlba
 */
public class FreeNode extends AbstractCutTreeNode {

    public FreeNode(@NonNull CutTreeNode parent, @NonNull Position position, @NonNull Dimension dimension) {
        super(parent, position, dimension);
    }

    @Override
    public void replaceChild(@NonNull CutTreeNode from, @NonNull CutTreeNode to) {
        throw new UnsupportedOperationException("Not supported: Freepanel.replace.");
    }

    public CutNode cut(double bladeWidth, double cutPosition, @NonNull CutNode.Direction direction) {
        final CutTreeNode parent = this.getParent();
        final CutNode cut = new CutNode(parent,
                bladeWidth, cutPosition, direction,
                getPosition(),
                getDimension());

        parent.replaceChild(this, cut);

        return cut;
    }

    public PanelNode setPanel(@NonNull PanelInstance panel) {
        final CutTreeNode parent = this.getParent();
        final PanelNode pn = new PanelNode(parent, panel, getPosition(), getDimension());
        parent.replaceChild(this, pn);
        return pn;
    }
}
