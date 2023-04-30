package HomeworksAdd.HWProjectOOP.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHandler implements Writable {
    @Override
    public void putToFile(Serializable ser, String Path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Path));
            oos.writeObject(ser);
            oos.close();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

    @Override
    public Object loadFromFile(String Path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Path));
            // Object ft = new Object(); ???
            // if ()
            // ois.read
            Object ft = ois.readObject();
            ois.close();
            return ft;
        } catch (Exception e) {
            return null;
        }
    }
}
