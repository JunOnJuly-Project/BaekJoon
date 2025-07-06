import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()); 
            String q = st.nextToken();
            
            int state;
            int x;
            switch(q){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) set.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    state = set.contains(x) ? 1 : 0;
                    bw.write(state + "\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all":
                    for (int j=0;j<20;j++) set.add(j+1);
                    break;
                case "empty":
                    set.clear();
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