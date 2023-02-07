//BS'D
/*
•	 GirlNames.txt – This file contains a list of the 200 most popular names given to girls
born in the United States for the years 2000 through 2009.
•	 BoyNames.txt – This file contains a list of the 200 most popular names given to boys
born in the United States for the years 2000 through 2009.
Write a program that reads the contents of the two files into two separate arrays, or
ArrayLists. The user should be able to enter a boy’s name, a girl’s name, or both, and
the application will display messages indicating whether the names were among the
most popular
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

public class NameSearch {
    public static void main(String[] args) throws FileNotFoundException {

        File girlNames = new File("GirlNames.txt");
        File boyNames = new File("BoyNames.txt");

        ArrayList<String> girls = new ArrayList<>();
        ArrayList<String> boys = new ArrayList<>();
        fill(girls, girlNames);
        fill(boys, boyNames);
        sort(girls);
        sort(boys);

        Scanner s = new Scanner(System.in);
        System.out.println("would you like to enter a boys name,a girls name, or both? (girl/boy/both)");
        String entry = s.next();
        String findBoy = "";
        String findGirl = "";
        if(entry.equalsIgnoreCase("girl")) {
            System.out.println("please enter a girls name");
            entry = s.next();
            findGirl = binarySearch(girls, entry);
        }
        else if(entry.equalsIgnoreCase("boy")){
            System.out.println("please enter a boys name");
            entry = s.next();
            findBoy = binarySearch(boys, entry);
        }
        else if(entry.equalsIgnoreCase("both")) {
            System.out.println("please enter a girls name followed by a boys name separated by a comma");
            entry = s.next();
            String[] str = entry.split(",",2);
                findGirl = binarySearch(girls,str[0] );
                findBoy = binarySearch(boys, str[1]);
            }

        if(findBoy != "")
            System.out.println("Boys name was found: " + findBoy);
        if(findGirl != "")
            System.out.println("Girls name was found: " + findGirl);



    }
    public static void fill(ArrayList<String> list, File file) throws FileNotFoundException {
        Scanner s  = new Scanner(file);
        while(s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return;
    }
    public static String binarySearch(ArrayList<String> list, String target) {
        int low = 0;
        int high = list.size() - 1;
        while(low <= high) {
            int middle = low + (high - low) / 2;
            String s = list.get(middle);
            if (s.equalsIgnoreCase(target))
                return s;
            else if (s.compareToIgnoreCase(target) > 1)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return "";
        }

}
