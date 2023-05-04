package HomeworksAdd.HWProjectOOP.view;

import java.util.Scanner;

import HomeworksAdd.HWProjectOOP.model.Person;
import HomeworksAdd.HWProjectOOP.presenter.Presenter;

public class ConsoleView implements View {
    private Scanner scan;
    private boolean work;
    Presenter presenter;

    public ConsoleView() {
        scan = new Scanner(System.in, "Cp866");
    }
    @Override
    public void start() {
        System.out.println("Начало работы.");
        presenter = new Presenter(this, "HomeworksAdd/HWProjectOOP/model/Tree.out");
        Menu menu = new Menu();
        work = true;
        int point = 0;
        while (work) {
            System.out.println(menu);
            point = scan.nextInt();
            if (point < 1 || point > (menu.getMenuSize() + 1)) {
                System.out.println("Выбор некорректен. Попробуйте ещё раз!");
            } else {    
            
                if (point == (menu.getMenuSize() + 1)) {
                    exit();
                    work = false;
                } 
                else menu.perform(point, this);
            }
        }
    }
    
    public void initialTree() {
        presenter.initTree();
        System.out.println("Дерево инициализировано, для просмотра дерева выберите пункт 2.");
        System.out.println();
    }
    public void printTree() {
        if (presenter.takeTree() == null) System.out.println("Требуется инициация дерева.");
        else {
            System.out.println("Текущее дерево =>");
            for (Person pers : presenter.takeTree()) {
                System.out.println(pers);
            }
        }
        System.out.println();
    }
    public void addToTree() {
        System.out.println("Выберите пол добавляемого человека: 1 - мужской, 2 - женский => ");
        int gender = scan.nextInt();
        System.out.print("Введите фамилию человека => ");
        scan.nextLine();
        String sername = scan.nextLine();
        System.out.print("Введите имя человека => ");
        // scan.nextLine();
        String firstname = scan.nextLine();
        System.out.print("Введите год рождения человека => ");
        int yearbirth = scan.nextInt();
        presenter.addPersonToTree(gender, sername, firstname, yearbirth);
        System.out.println("Человек добавлен.");
        System.out.println();
    }
    public void delFromTree() {
        System.out.print("Введите id человека, которого хотим удалить => ");
        int id = scan.nextInt();
        presenter.delPersonFromTree(id);
        System.out.println("Человек с id=" + id + " удален из дерева.");
        System.out.println();
    }
    private void exit(){
        System.out.println("Завершение работы.");
        // scan.close();
        // work = false;
    }
}
