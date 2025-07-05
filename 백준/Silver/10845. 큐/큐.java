import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Deque<Integer> dq = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            
            int state;
            switch (q){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    dq.addLast(num);
                    break;
                case "pop":
                    state = dq.isEmpty() ? -1 : dq.pollFirst();
                    bw.write(state + "\n");
                    break;
                case "size":
                    state = dq.size();
                    bw.write(state + "\n");
                    break;
                case "empty":
                    state = dq.isEmpty() ? 1 : 0;
                    bw.write(state + "\n");
                    break;
                case "front":
                    state = dq.isEmpty() ? -1 : dq.peekFirst();
                    bw.write(state + "\n");
                    break;
                case "back":
                    state = dq.isEmpty() ? -1 : dq.peekLast();
                    bw.write(state + "\n");
                    break;
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