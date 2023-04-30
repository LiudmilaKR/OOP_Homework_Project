package HomeworksAdd.HWProjectOOP.presenter;

import HomeworksAdd.HWProjectOOP.model.FamilyTree;
import HomeworksAdd.HWProjectOOP.model.Service;
import HomeworksAdd.HWProjectOOP.view.View;

public class Presenter {
    View view;
    Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
    }
    public void initTree() {
        service.newFamilyTree();
        service.saveToFile();
    }
    public FamilyTree takeTree() {
        return service.takeFromFile();
    }
    public void addPersonToTree(int g, String sn, String fn, int yb) {
        service.addPersToTree(g, sn, fn, yb);
    }
    public void delPersonFromTree(String sn, int yb) {
        service.delPersFromTree(sn, yb);
    }
}
