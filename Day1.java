import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Integer.parseInt;
import java.util.Collections;

public class Day1 {
    static ArrayList<Integer> row1=new ArrayList();
    static ArrayList<Integer> row2=new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        for (int i=0; i<fileData.size(); i++) {
            String sample = fileData.get(i);
            String[] splitSample = sample.split("   ");
            row1.add(Integer.parseInt(splitSample[0]));
            row2.add(Integer.parseInt(splitSample[1]));
        }
        int sum=0;
        Collections.sort(row1);
        Collections.sort(row2);

        for (int i=0; i<row1.size(); i++) {
            int distance=Math.abs(row1.get(i)-row2.get(i));
            sum+=distance;
        }
        System.out.println(sum);
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
