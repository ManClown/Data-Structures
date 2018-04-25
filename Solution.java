import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.ArrayList;

public class Solution {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries){
        
        int type, x, y;
        int lastAnswer = 0;
        ArrayList< ArrayList<Integer> > seqList = new ArrayList< ArrayList<Integer> >();
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        for(int i = 0; i < n; ++i){
            seqList.add(new ArrayList<Integer>());
        }
        
        for(int k = 0; k < queries.length; ++k){
            type = queries[k][0];
            x = queries[k][1];
            y = queries[k][2];
            switch(type){
                case 1:
                    seqList.get((x^lastAnswer) % n).add(y);
                    break;
                case 2:
                    ArrayList<Integer> seq = seqList.get((x^lastAnswer) % n);
                    lastAnswer = seq.get(y % seq.size());
                    results.add(lastAnswer);
                    break;
            }
                
        }
        int[] rs = new int[results.size()];
        for(int j = 0; j < results.size(); ++j)
            rs[j] = results.get(j);
        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}