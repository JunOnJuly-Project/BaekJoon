import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            int A, B;
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            if (A==0 || B==0) {
                break;
            }
            
            bw.write(A+B+"\n");
        }
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}