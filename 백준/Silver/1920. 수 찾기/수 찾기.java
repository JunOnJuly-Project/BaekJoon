import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Set<Integer> nums = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            if (nums.contains(Integer.parseInt(st.nextToken()))){
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}