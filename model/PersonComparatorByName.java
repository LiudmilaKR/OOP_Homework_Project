package HomeworksAdd.HWProjectOOP.model;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return (o1.getLastName() + o1.getFirstName()).compareTo(o2.getLastName() + o2.getFirstName());
    }
    
}
