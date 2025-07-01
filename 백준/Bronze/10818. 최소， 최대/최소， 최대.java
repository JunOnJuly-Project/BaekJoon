import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1000001;
        int min = 1000001;
        for (int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        
        bw.write(String.format("%d %d", min, max));
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}