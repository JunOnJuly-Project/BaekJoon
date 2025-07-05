import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Stack<Integer> stk = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            
            int state;
            switch (q){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stk.push(num);
                    break;
                case "pop":
                    state = stk.empty() ? -1 : stk.pop();
                    bw.write(state + "\n");
                    break;
                case "size":
                    state = stk.size();
                    bw.write(state + "\n");
                    break;
                case "empty":
                    state = stk.empty() ? 1 : 0;
                    bw.write(state + "\n");
                    break;
                case "top":
                    state = stk.empty() ? -1 : stk.peek();
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