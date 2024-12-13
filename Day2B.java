import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day2B {
    static int tracker=0;
    static int check1=0;
    static int check2=0;
    public static void main(String[] args) {
        ArrayList<Integer> numList=new ArrayList<Integer>();
        ArrayList<String> fileData = getFileData("src/input");
        int safe = 0;
        for (int i = 0; i < fileData.size(); i++) {
            tracker=0;
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
        if ((areIncreasing(test) || areDecreasing(test)) && differ(test)) {
            if (!(check1>1 && check2>1)) {
                outcome=1;
            }
        }
        return outcome;
    }
    public static boolean areIncreasing(ArrayList<Integer> test) {
        int prev=-1;
        check1=0;
        for (int i=0; i<test.size(); i++) {
            if (test.get(i)<=prev) {
                check1++;
                if (check1>1) {
                    return false;
                }
            }
            prev=test.get(i);
        }
        return true;
    }
    public static boolean areDecreasing(ArrayList<Integer> test) {
        int prev=10000;
        check2=0;
        for (int i=0; i<test.size(); i++) {
            if (test.get(i)>=prev) {
                check2++;
                if (check2>1) {
                    return false;
                }
            }
            prev=test.get(i);
        }
        return true;
    }
    public static boolean differ(ArrayList<Integer> test) {
        for (int i=0; i<test.size()-1; i++) {
            if (!(Math.abs(test.get(i)-test.get(i+1))>=1 && Math.abs(test.get(i)-test.get(i+1))<=3)) {
                if (tracker>1) {
                    return false;
                }
                if (check1<=1 || check2<=1) {
                    tracker++;
                } else {
                    return false;
                }
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
