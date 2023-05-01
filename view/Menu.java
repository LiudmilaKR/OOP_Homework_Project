package HomeworksAdd.HWProjectOOP.view;

import java.util.ArrayList;
import java.util.List;

import HomeworksAdd.HWProjectOOP.view.comands.Comand;
import HomeworksAdd.HWProjectOOP.view.comands.Exit;
import HomeworksAdd.HWProjectOOP.view.comands.Init;

public class Menu {
    private List<Comand> comandList;
    int index = 1;

    public Menu(List<Comand> comandList) {
        comandList = new ArrayList<>();
        comandList.add(index++, new Init());
        comandList.add(index++, new Exit());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие:\n");
        // int i = 1;
        for (Comand item : comandList) {
            // sb.append(i++);
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }
}
