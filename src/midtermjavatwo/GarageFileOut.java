
package midtermjavatwo;

import java.io.*;

/**
 * This pushes the parking Garage file out
 *
 * @throws FileNotFoundException if the file has an open error, prints files name
 */
public class GarageFileOut {

    Writer out = null;
    private String fileName;

    public GarageFileOut(String fileName) {
        this.fileName = fileName;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " "  + e);
        }
    }

    /**
    * This writes each line to the File
    *
    * @throws FileNotFoundException if the file has an open error, prints files name
    */
    public void fileWrite(String line) {
        try {
            out.write(line+"\n");
        }
        catch(Exception e) {
            System.out.println("File Write Error: " + fileName + " "  + e);
        }
    }

    /**
    * This closes out the file
    *
    * @throws FileNotFoundException if the file has an open error, prints files name
    */
    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
