import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        String searchString = getFileData("src/input");
        ArrayList<String> allMatches = new ArrayList<String>();
        ArrayList<String> permMatches = new ArrayList<String>();
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
        String perms="\\(['do\\(\\)']['don't\\(\\)']\\)";
        Matcher m = Pattern.compile(regex).matcher(searchString);
        Matcher p = Pattern.compile(regex).matcher(perms);
        while (m.find()) {
            allMatches.add(m.group());
        }
        while (p.find()) {
            permMatches.add(p.group());
        }
        System.out.println(allMatches);
        System.out.println(permMatches);
        int sum=0;
        for (int i=0; i<allMatches.size(); i++) {
            sum+=mul(allMatches.get(i));
        }
        System.out.println(sum);
    }
    public static int mul(String test) {
        String[] splitSample = test.split(",");
        String[] split1 = splitSample[0].split("\\(");
        String[] split2 = splitSample[1].split("\\)");
        int num1=Integer.parseInt(split1[1]);
        int num2=Integer.parseInt(split2[0]);
        int product=num1*num2;
        return product;
    }
    public static String getFileData(String fileName) {
        String fileData = "";
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData+=line;
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
