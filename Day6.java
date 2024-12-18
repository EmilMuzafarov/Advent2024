import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Day6 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        ArrayList<String> fileData = getFileData("src/input");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length-1; c++) {
                grid[r][c]=fileData.get(r).substring(c,c+1);
            }
        }
        System.out.println(Arrays.deepToString(grid));
    }
    public static String findGuard(String[][] test) {
        String coord="";
        for (int i=0; i<test.length; i++) {
            for (int j=0; j<test[0].length; j++) {
                if (test[i][j].equals("^")) {
                    coord=i+" "+j;
                }
            }
        }
        return coord;
    }
    public static void move() {
        
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
