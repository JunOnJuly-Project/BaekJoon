import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        for (int i=N;i>0;i--) bw.write(i + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}