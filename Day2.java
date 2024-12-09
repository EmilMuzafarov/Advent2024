import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        // build a 2D Array based on the length of each string and the size of the list
        // e.g
        // ABCD
        // EFGH
        // IJKL
        // This would be a 3 row, 4 column 2D array
        ArrayList<Integer> numlist=new ArrayList<Integer>();
        for (int i=0; i<fileData.size(); i++) {
            String[] splitSample = fileData.get(i).split(" ");
            for (int j=0; j<splitSample.length; j++) {
                numlist.add(Integer.parseInt(splitSample[j]));
            }
            numlist.add(1111);
        }
        System.out.println(numlist);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}