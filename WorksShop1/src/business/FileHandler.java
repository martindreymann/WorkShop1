package business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileHandler {

    File file;
    ObjectOutputStream out;
    ObjectInputStream in;

    public FileHandler() throws IOException {
        file = new File("data.binary");
        file.createNewFile();
    }

    public void saveFile(BuildingSystem bs) throws FileNotFoundException, IOException {
        FileOutputStream stream = new FileOutputStream(file);
        out = new ObjectOutputStream(stream);
        out.writeObject(bs);
        out.flush();
        out.close();
    }

    public BuildingSystem loadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream stream = new FileInputStream(file);
        in = new ObjectInputStream(stream);
        BuildingSystem bs = (BuildingSystem) in.readObject();
        in.close();
        return bs;
    }

}
