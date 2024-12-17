import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }
        int occur=0;
        System.out.println(Arrays.deepToString(grid));
        for (int a=0; a<grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b].equals("X") && b<grid[0].length-4 && a<grid.length-4) {
                    int row=a;
                    int col=b;
                    if (ADiagonal(grid, "XMAS", row, col)) {
                        occur++;
                    }
                    if (BDiagonal(grid, "XMAS", row, col)) {
                        occur++;
                    }
                }
                if (grid[a][b].equals("S") && b>4 && a<grid.length-4) {
                    int row=a;
                    int col=b;
                    if (ADiagonal(grid, "SMAX", row, col)) {
                        occur++;
                    }
                    if (BDiagonal(grid, "SMAX", row, col)) {
                        occur++;
                    }
                    System.out.println(occur);
                }
            }
        }
        System.out.println(occur);
    }
    public static boolean ADiagonal(String[][] test, String search, int row, int col) {
        int i=0;
        int match=0;
        for (int c = col; c < col+4; c++) {
            if (!(test[row][c].equals(search.substring(i,i+1)))) {
                return false;
            }
            match++;
            if (match==4) {
                return true;
            }
            row++;
            i++;
        }
        return true;
    }
    public static boolean BDiagonal(String[][] test, String search, int row, int col) {
        int i=0;
        int match=0;
        for (int c = col; c > col-4; c--) {
            if (!(test[row][c].equals(search.substring(i,i+1)))) {
                return false;
            }
            match++;
            if (match==4) {
                return true;
            }
            row++;
            i++;
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
