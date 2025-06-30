import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        int n = Integer.parseInt(br.readLine());
        for (int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            
            int A, B;
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            bw.write("Case #" + i + ": " + A + " + " + B + " = " + (A+B) + "\n");
        }
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}