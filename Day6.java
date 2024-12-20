import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Day6 {
    static int posX;
    static int posY;
    static int loc=0;
    static boolean right=false;
    static boolean down=false;
    static boolean up=true;
    static boolean left=false;
    public static String[][] grid;
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        grid = new String[rows][columns];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c]=fileData.get(r).substring(c,c+1);
            }
        }
        findGuard(grid);
        move();
        System.out.println(loc);
    }
    public static void findGuard(String[][] test) {
        for (int i=0; i<test.length; i++) {
            for (int j=0; j<test[0].length; j++) {
                System.out.println(test[i][j]);
                if (test[i][j].equals("^")) {
                    posY=i;
                    posX=j;
                }
            }
        }
    }
    public static void move() {
        boolean end=false;
        while (!end) {
            eval();
            if (!grid[posY-1][posX].equals("#") && up) {
                if (posY < 0) {
                    System.out.println("The guard left");
                    System.out.println(loc);
                    end = true;
                }
                grid[posY][posX] = "X";
                posY--;
                grid[posY][posX] = "^";
                loc++;
            }
            if (!grid[posY][posX+1].equals("#") && right) {
                if (posX > grid[0].length) {
                    System.out.println("The guard left");
                    grid[posY][posX] = "X";
                    System.out.println(loc);
                    end = true;
                } else {
                    grid[posY][posX] = "X";
                    posX++;
                    grid[posY][posX] = "^";
                }
                loc++;
            }
            if (!grid[posY+1][posX].equals("#") && down) {
                if (posY > grid.length) {
                    System.out.println("The guard left");
                    grid[posY][posX] = "X";
                    System.out.println(loc);
                    end = true;
                } else {
                    grid[posY][posX] = "X";
                    posY++;
                    grid[posY][posX] = "^";
                }
                loc++;
            }
            if (!grid[posY][posX-1].equals("#") && left) {
                if (posX < 0) {
                    System.out.println("The guard left");
                    grid[posY][posX] = "X";
                    System.out.println(loc);
                    end = true;
                } else {
                    grid[posY][posX] = "X";
                    posX--;
                    grid[posY][posX] = "^";
                }
                loc++;
            }
            System.out.println(posX);
            System.out.println(posY);
            System.out.println(Arrays.deepToString(grid));
            System.out.println(loc);
        }
    }
    public static void eval() {
        if (right) {
            down=true;
            right=false;
        }
        if (down) {
            left=true;
            down=false;
        }
        if (left) {
            up=true;
            left=false;
        }
        if (up) {
            right=true;
            up=false;
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
