import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import java.util.Collections;
public class Day1B {
    static int score=0;
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
        update();
        System.out.println(score);
    }
    public static void update(){
        int occur;
        int num;
        for (int i=0; i<row1.size(); i++) {
            occur=0;
            num=row1.get(i);
            for (int j=0; j<row2.size(); j++) {
                if (row2.get(j)==num) {
                    occur++;
                }
            }
            score+=(occur*num);
        }
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