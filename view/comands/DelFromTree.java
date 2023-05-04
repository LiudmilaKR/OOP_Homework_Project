package HomeworksAdd.HWProjectOOP.view.comands;

import HomeworksAdd.HWProjectOOP.view.ConsoleView;

public class DelFromTree implements Comand {

    @Override
    public void execute(ConsoleView console) {
        console.delFromTree();
    }
    
    @Override
    public String toString() {
        return "Удаление человека из дерева";
    }

   
    
}
