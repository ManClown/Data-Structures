import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution_A {

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
        for(int i = 0; i < d; ++i){
            int a_head = a[0];
            for(int aItr = 1; aItr < a.length; ++aItr)
                a[aItr-1] = a[aItr];
            a[a.length-1] = a_head;
        }
        for(int aItr = 0; aItr < n; ++aItr){
            if(aItr == n-1) System.out.println(a[aItr]);
            else System.out.print(a[aItr]+" ");
        }
    }
}
