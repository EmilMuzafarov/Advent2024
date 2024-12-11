import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day2 {

    public static void main(String[] args) {
        ArrayList<Integer> numList=new ArrayList<Integer>();
        ArrayList<String> fileData = getFileData("src/input");
        int safe = 0;
        for (int i = 0; i < fileData.size(); i++) {
            numList.clear();
            String[] splitSample = fileData.get(i).split(" ");
            for (int j = 0; j < splitSample.length; j++) {
                numList.add(Integer.parseInt(splitSample[j]));
                if (j == splitSample.length - 1) {
                    safe += safe(numList);
                }
            }
        }
        System.out.println(safe);
    }
    public static int safe(ArrayList<Integer> test) {
        int outcome=0;
        for (int i=0; i<test.size(); i++) {
            if ((areIncreasing(test) || areDecreasing(test)) && differ(test)) {
                outcome=1;
            }
        }
        return outcome;
    }
    public static boolean areIncreasing(ArrayList<Integer> test) {
        int prev=-1;
        for (int i=0; i<test.size(); i++) {
            if (test.get(i)<=prev) {
                return false;
            }
            prev=test.get(i);
        }
        return true;
    }
    public static boolean areDecreasing(ArrayList<Integer> test) {
        int prev=10000;
        for (int i=0; i<test.size(); i++) {
            if (test.get(i)>=prev) {
                return false;
            }
            prev=test.get(i);
        }
        return true;
    }
    public static boolean differ(ArrayList<Integer> test) {
        for (int i=0; i<test.size()-1; i++) {
            if (!(Math.abs(test.get(i)-test.get(i+1))>=1 && Math.abs(test.get(i)-test.get(i+1))<=3)) {
                return false;
            }
        }
        return true;
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
