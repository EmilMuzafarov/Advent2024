import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Integer.parseInt;

public class Day1 {
    static List<Integer> row1=new ArrayList();
    static ArrayList<Integer> row2=new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        for (int i=0; i<fileData.size(); i++) {
            String sample = fileData.get(i);
            String[] splitSample = sample.split(" ");
            row1.add(Integer.parseInt(splitSample[0]));
            row2.add(Integer.parseInt(splitSample[1]));
        }
        ArrayList<Integer> min1 = new ArrayList<>();
        ArrayList<Integer> min2 = new ArrayList<>();
        int sum1=0;
        int small1=0;
        for (int x=0; x<row1.size(); x++) {
            min1.add(findMin(small1,row1.get(x)));
        }
        System.out.println(findMin(-1, row1));
    }
    public static int findMin(int param, ArrayList<Integer> arr) {
        int min=999999999;
        if (param>-1) {
            min=param;
        }
        for (int a=0; a<arr.size(); a++) {
            if (arr.get(a)<min) {
                min=arr.get(a);
            }
        }
        return min;
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
