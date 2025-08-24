import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] threeMod = new int[10];
        threeMod[0] = 0;
        threeMod[1] = 7;
        threeMod[2] = 4;
        threeMod[3] = 1;
        threeMod[4] = 8;
        threeMod[5] = 5;
        threeMod[6] = 2;
        threeMod[7] = 9;
        threeMod[8] = 6;
        threeMod[9] = 3;
        
        int sum = 0;
        int idx = -1;
        String n = br.readLine();
        for (int i = 0; i < n.length(); i++) {
        	if (n.charAt(i) == '*') {
        		idx = i;
        		continue;
        	}
        	else if (i%2 == 0) {
        		sum += n.charAt(i) - '0';
        	}
        	else {
        		sum += (n.charAt(i) - '0') * 3;
        	}
        }
        
        bw.write(sum % 10 == 0 ? 0 + "" : idx % 2 == 0 ? 10 - sum % 10 + "" : threeMod[(10 - sum % 10)] + "");
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}