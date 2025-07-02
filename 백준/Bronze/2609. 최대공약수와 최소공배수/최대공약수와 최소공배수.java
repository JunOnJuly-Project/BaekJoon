import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int A, B;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int mulAB = A*B;
        
        int mod;
        while ((mod = A%B) != 0){
            A = B;
            B = mod;
        }
        
        bw.write(B + "\n");
        bw.write(mulAB/B + "\n");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}