
package midtermjavatwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This creates the buffered reader for the Garage
 *
 */
public class GarageFileIn {

    private BufferedReader in = null;
    private String fileName;

/**
 * This creates puts the file into the reader
 * This is a constructor
 * @param fileName opens the File with the name fileName for the buffered reader
 * @throws FileNotFoundException if the file has an open error, prints files name
 */
    public GarageFileIn(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {

            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }
    /**
     * This reads each line of the file
     *
     * @exception FileNotFoundException e if the file has an open error, prints files name
     * @return null 
     */
    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
            return null;
        }
    }
    /**This closes the file after we are done with it.
     *
     *
     * 
     */
    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
