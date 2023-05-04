package HomeworksAdd.HWProjectOOP.view.comands;

import HomeworksAdd.HWProjectOOP.view.ConsoleView;

public class AddToTree implements Comand {

    @Override
    public void execute(ConsoleView console) {
        console.addToTree();
    }

    @Override
    public String toString() {
        return "Добавление человека в дерево";
    }
    
}
