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
        System.out.println(Arrays.deepToString(grid));
        for (int a=0; a<grid.length; a++) {
            boolean go=false;
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b].equals("X") && b<grid[0].length-4 && a<grid.length-4) {
                    int row=a;
                    int col=b;
                    findDiagonal(grid, "XMAS", row, col);
                }
            }
        }
    }
    public static boolean findDiagonal(String[][] test, String search, int row, int col) {
        for (int r = row; r < test.length; r++) {
            for (int c = col; c < test[0].length; c++) {
                if (!(test[r][c].equals(search.substring(0,1)) || test[r][c].equals(search.substring(search.length()-1,search.length())))) {
                    return false;
                } else {
                    r++;
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