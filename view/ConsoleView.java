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
        work = true;
        int point = 0;
        while (work) {
            System.out.println("Выберите действие:\n1.Инициация изначального дерева\n" + 
                        "2.Вывод текущего дерева на консоль\n" + "3.Добавление человека в дерево\n" + 
                        "4.Удаление человека из дерева\n" + "5.Выход");
            point = scan.nextInt();
            switch (point) {
                case (1):
                    initialTree();
                break;
                case (2):
                    printTree();
                    break;
                case (3):
                    addToTree();
                    break;
                case (4):
                    delFromTree();
                    break;
                case (5):
                    exit();
                    break;
                default:
                    System.out.println("Выбор некорректен. Попробуйте ещё раз!");
                    break;
            }
        }
    }
    
    private void initialTree() {
        presenter.initTree();
        System.out.println("Дерево инициализировано, для просмотра дерева выберите пункт 2.");
        System.out.println();
    }
    private void printTree() {
        if (presenter.takeTree() == null) System.out.println("Требуется инициация дерева.");
        else {
            System.out.println("Текущее дерево =>");
            for (Person pers : presenter.takeTree()) {
                System.out.println(pers);
            }
        }
        System.out.println();
    }
    private void addToTree() {
        System.out.println("Выберите пол добавляемого человека: 1 - мужской, 2 - женский => ");
        int g = scan.nextInt();
        System.out.print("Введите фамилию человека => ");
        scan.nextLine();
        String sn = scan.nextLine();
        System.out.print("Введите имя человека => ");
        // scan.nextLine();
        String fn = scan.nextLine();
        System.out.print("Введите год рождения человека => ");
        int yb = scan.nextInt();
        presenter.addPersonToTree(g, sn, fn, yb);
        System.out.println("Человек добавлен.");
        System.out.println();
    }
    private void delFromTree() {
        System.out.print("Введите id человека, которого хотим удалить => ");
        int id = scan.nextInt();
        presenter.delPersonFromTree(id);
        System.out.println("Человек с id=" + id + " удален из дерева.");
        System.out.println();
    }
    private void exit(){
        System.out.println("Завершение работы.");
        // scan.close();
        work = false;
    }
}
