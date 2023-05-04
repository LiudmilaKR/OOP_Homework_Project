package HomeworksAdd.HWProjectOOP.model;

public class Service {
    FamilyTree ft;
    private String path;
    private Writable handler;
    private int id;

    public Service(String path) {
        this.path = path;
        this.id = 1;
        handler = new FileHandler();
        // ft = new FamilyTree();
        ft = takeFromFile();
    }

    public void saveToFile(FamilyTree familyTree) {
        sortByYearBirsday();
        handler.putToFile(familyTree, path);
    }
    public FamilyTree takeFromFile() {
        // ft = new FamilyTree();
        ft = (FamilyTree) handler.loadFromFile(path);
        return ft;
    }
    public void sortByYearBirsday() {
        ft.getFamilyTree().sort(new PersonComparatorByYearBirsday());
    }
    public void sortByName() {
        ft.getFamilyTree().sort(new PersonComparatorByName());
    }
    public void addPersToTree(int gender, String sername, String firstname, int yearbirth) {
        for (Person per : ft) {
            if (per.getId() > id) id = per.getId() + 3;
        }
        Person person = new Person(id, sername, firstname, yearbirth, null, null, null);
        if (gender == 1) person.setGender(Gender.Male);
        else person.setGender(Gender.Female);
        ft.addToFamilyTree(person);
        saveToFile(ft);
    }
    public void delPersFromTree(int i) {
        for (Person pers : ft) {
            if (pers.getId() == i) ft.removeFromFamilyTree(pers);
        }
        saveToFile(ft);
    }
    public FamilyTree newFamilyTree() {
        Person person1 = new Person(91, "Иванов", "Петр", 1962, Gender.Male, null, null);
        Person person2 = new Person(92, "Иванова", "Наталья", 1965, Gender.Female, null, null);
        Person person3 = new Person(93, "Иванов", "Егор", 1986, Gender.Male, person1, person2);
        Person person4 = new Person(94, "Иванов", "Сергей", 1990, Gender.Male, person1, person2);
        Person person7 = new Person(95, "Григорьев", "Петр", 1968, Gender.Male, null, null);
        Person person8 = new Person(96, "Григорьева", "Алина", 1971, Gender.Female, null, null);
        Person person5 = new Person(97, "Иванова", "Марина", 1990, Gender.Female, person7, person8);
        Person person6 = new Person(98, "Иванов", "Алексей", 2022, Gender.Male, person3, person5);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addToFamilyTree(person1);
        familyTree.addToFamilyTree(person2);
        familyTree.addToFamilyTree(person3);
        familyTree.addToFamilyTree(person4);
        familyTree.addToFamilyTree(person5);
        familyTree.addToFamilyTree(person6);
        familyTree.addToFamilyTree(person7);
        familyTree.addToFamilyTree(person8);
        return familyTree;
    }
}
