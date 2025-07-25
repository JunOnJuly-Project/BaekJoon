import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int max = -1;
        int idx = -1;
        
        for (int i=1;i<=9;i++){
            int num = Integer.parseInt(br.readLine());
            
            if (num > max){
                max = num;
                idx = i;
            }
        }

        bw.write(max + "\n");
        bw.write(idx + "\n");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}