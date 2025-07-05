import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i=0;i<N;i++){
            dq.addLast(i+1);
        }
        
        bw.write("<");
        for (int i=0;i<N;i++){
            for (int j=0;j<K-1;j++){
                dq.addLast(dq.pollFirst());
            }
            bw.write(dq.pollFirst()+"");
            if (i != N-1) bw.write(", ");
        }
        
        bw.write(">");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}