package git.lunf.testing;


import git.lunf.model.Panel;
import git.lunf.model.Project;

import java.util.List;

public class PartData extends AbstractTestData {

    private final List<Panel> panelList;
    public PartData(List<Panel> partList) {
        this.panelList = partList;
    }

    @Override
    public Project getData() {
        return makeProject(this.panelList, 12);
    }

    @Override
    public String getTitle() {
        return "Grande Data";
    }
}
