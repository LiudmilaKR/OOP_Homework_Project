package HomeworksAdd.HWProjectOOP.view.comands;

import HomeworksAdd.HWProjectOOP.view.ConsoleView;

public class ShowTree implements Comand {

    @Override
    public void execute(ConsoleView console) {
        console.printTree();
    }

    @Override
    public String toString() {
        return "Вывод текущего дерева на консоль";
    }
    
}
