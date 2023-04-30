package HomeworksAdd.HWProjectOOP.model;

public class Service {
    FamilyTree ft;
    private String path;

    public Service(String path) {
        this.path = path;
        ft = new FamilyTree();
    }

    public void saveToFile() {
        sortByYearBirsday();
        for (Person person : ft) {
            FileHandler fh = new FileHandler();
            fh.putToFile(person, path);
        }
    }
    public FamilyTree takeFromFile() {
        FileHandler fh = new FileHandler();
        Person person = (Person) fh.loadFromFile(path);
        ft.addToFamilyTree(person);
        return ft;
    }
    public void sortByYearBirsday() {
        ft.getFamilyTree().sort(new PersonComparatorByYearBirsday());
    }
    public void sortByName() {
        ft.getFamilyTree().sort(new PersonComparatorByName());
    }
    public void addPersToTree(int g, String sn, String fn, int yb) {
        Person person = new Person(sn, fn, yb, null, null, null);
        if (g == 1) person.setGender(Gender.Male);
        else person.setGender(Gender.Female);
        FileHandler fh = new FileHandler();
        fh.putToFile(person, path);
    }
    public void delPersFromTree(String sn, int yb) {
        // Person person = new Person(sn, sn, 0, null, null, null);
        for (Person pers : ft) {
            if (pers.getLastName().equals(sn) && (pers.getYearBithday() == yb)) ft.getFamilyTree().remove(pers);
        }
    }
    public FamilyTree newFamilyTree() {
        Person person1 = new Person("Иванов", "Петр", 1962, Gender.Male, null, null);
        Person person2 = new Person("Иванова", "Наталья", 1965, Gender.Female, null, null);
        Person person3 = new Person("Иванов", "Егор", 1986, Gender.Male, person1, person2);
        Person person4 = new Person("Иванов", "Сергей", 1990, Gender.Male, person1, person2);
        Person person7 = new Person("Григорьев", "Петр", 1968, Gender.Male, null, null);
        Person person8 = new Person("Григорьева", "Алина", 1971, Gender.Female, null, null);
        Person person5 = new Person("Иванова", "Марина", 1990, Gender.Female, person7, person8);
        Person person6 = new Person("Иванов", "Алексей", 2022, Gender.Male, person3, person5);
        // FamilyTree familyTree1 = new FamilyTree();
        ft.addToFamilyTree(person1);
        ft.addToFamilyTree(person2);
        ft.addToFamilyTree(person3);
        ft.addToFamilyTree(person4);
        ft.addToFamilyTree(person5);
        ft.addToFamilyTree(person6);
        ft.addToFamilyTree(person7);
        ft.addToFamilyTree(person8);
        return ft;
    }
}
