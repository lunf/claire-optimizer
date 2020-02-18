/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */
package git.lunf.data.cuttree;

import git.lunf.model.Dimension;
import git.lunf.model.PanelInstance;
import git.lunf.model.Position;
import lombok.NonNull;
import lombok.ToString;

/**
 *
 * @author rmuehlba
 */
@ToString
public class PanelNode extends AbstractCutTreeNode {

    private final PanelInstance panel;

    public PanelNode(@NonNull final CutTreeNode parent,
            @NonNull final PanelInstance panel,
            @NonNull final Position position,
            @NonNull final Dimension dimension) {

        super(parent, position, dimension);
        this.panel = panel;
    }

    public PanelInstance getPanel() {
        return panel;
    }

    @Override
    public void replaceChild(@NonNull final CutTreeNode from, @NonNull final CutTreeNode to) {
        throw new UnsupportedOperationException("Not supported: Freepanel.replace.");
    }
}
