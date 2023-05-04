package HomeworksAdd.HWProjectOOP.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String lastName;
    private String firstName;
    private int yearBithday;
    private Gender gender;
    private Person father;
    private Person mother;
    List<Person> children;
    
    public Person(int id, String lastName, String firstName, int yearBithday, Gender gender, Person father, Person mother) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.yearBithday = yearBithday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int getYearBithday() { return yearBithday; }
    public Person getFather() { return father; }
    public Person getMother() { return mother; }
    public void setGender(Gender gender) { this.gender = gender; }
    
    public String putGender() {
        if (gender == Gender.Male) return "пол мужской";
        else return "пол женский"; 
    }
    public boolean addChild(Person child) {
        if (children.contains(child)) return false;
        else {
            children.add(child);
            return true;
        }
    }
    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if (children.isEmpty()) sb.append(", детей нет");
        else {
            if (children.size() == 1) sb.append(", ребенок " + firstName + " " + lastName + " " + yearBithday);
            else {
                sb.append(", дети:");
                for (Person pers : children) {
                    sb.append(" " + pers.firstName + " " + pers.lastName + " " + pers.yearBithday + ",");
                }
            }
        }
        return sb.toString();
    }
    public String getFatherInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("отец");
        if (father == null) sb.append(" отсутсвует");
        else {
            sb.append(" " + father.lastName);
            sb.append(" " + father.firstName);
        }
        return sb.toString();
    }
    public String getMotherInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("мать");
        if (mother == null) sb.append(" отсутствует");
        else {
            sb.append(" ");
            sb.append(mother.lastName);
            sb.append(" ");
            sb.append(mother.firstName);
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person => [id=" + id + ", " + lastName + " " + firstName + " " + yearBithday + ", " + putGender());
        sb.append(", " + getFatherInfo() + ", " + getMotherInfo());
        sb.append(getChildrenInfo());
        sb.append("]");
        return sb.toString();
        
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person pers = (Person) obj;
        return pers.getLastName().equals(getLastName()) && 
            pers.getFirstName().equals(getFirstName()) && 
            (pers.getYearBithday() == getYearBithday());
    }
}
