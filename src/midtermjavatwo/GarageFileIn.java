
package midtermjavatwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This creates the buffered reader for the Garage
 * @param in 
 * @param fileName creates the fileName for the buffered reader
 */
public class GarageFileIn {

    private BufferedReader in = null;
    private String fileName;

/**
 * This creates puts the file into the reader
 * @param fileName creates the fileName for the buffered reader
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
     * Sam, I honestly can't remember what this does
     * @param in
     * @parm fileName creates the fileName for the buffered reader
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
    /**I hate file readers. That's what this does right?
     * @param in which is something to do with the reader
     * @throws the freaking same exception
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
