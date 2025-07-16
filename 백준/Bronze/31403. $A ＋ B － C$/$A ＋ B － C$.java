import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String A, B, C;
        A = br.readLine();
        B = br.readLine();
        C = br.readLine();
        
        bw.write(Integer.parseInt(A)+Integer.parseInt(B)-Integer.parseInt(C)+"\n");
        bw.write(Integer.parseInt(A+B)-Integer.parseInt(C)+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}