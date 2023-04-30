package HomeworksAdd.HWProjectOOP.model;

import java.util.Comparator;

public class PersonComparatorByYearBirsday implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getYearBithday(), o2.getYearBithday());
    }
    
}
