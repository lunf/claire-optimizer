/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */

package git.lunf.data.cuttree;

import git.lunf.model.Dimension;
import git.lunf.model.PanelInstance;
import git.lunf.model.Position;
import lombok.NonNull;

import java.io.Serializable;

/**
 *
 * @author rmuehlba
 */
public abstract class AbstractCutTreeNode implements CutTreeNode, Serializable {

    private final CutTreeNode parent;

    private final Position position;
    private final Dimension dimension;

    public AbstractCutTreeNode(@NonNull final CutTreeNode parent, 
            @NonNull final Position position, 
            @NonNull final Dimension dimension) {
        
        this.dimension = dimension;
        this.position = position;
        this.parent = parent;
    }

    public boolean canHold(@NonNull final PanelInstance p) {
        return getDimension().canHold(p.getDimension());
    }

    public CutTreeNode getParent() {
        return parent;
    }

    public Position getPosition() {
        return position;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
