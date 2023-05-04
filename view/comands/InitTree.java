package HomeworksAdd.HWProjectOOP.view.comands;

import HomeworksAdd.HWProjectOOP.view.ConsoleView;

public class InitTree implements Comand {

    @Override
    public void execute(ConsoleView console) {
        console.initialTree();
    }
    
    @Override
    public String toString() {
        return "Инициация изначального дерева";
    }

    
}
