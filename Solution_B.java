import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution_B {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scan.nextLine().split(" ");

        int n = Integer.parseInt(nd[0].trim());

        int d = Integer.parseInt(nd[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }
        int [] b = new int[a.length];
        for(int aItr = 0; aItr < a.length; ++aItr){
            b[(a.length+aItr-d)%a.length] = a[aItr];
        }
        for(int bItr = 0; bItr < b.length; ++bItr){
            if(bItr == b.length-1) System.out.println(b[bItr]);
            else System.out.print(b[bItr]+" ");
        }
    }
}
