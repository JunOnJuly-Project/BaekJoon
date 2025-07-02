import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> idx = new HashMap<>();
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            if (idx.containsKey(x)) idx.get(x).add(y);
            else idx.put(x, new ArrayList<>(Arrays.asList(y)));
        }
        
        Integer[] keys = idx.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        for (int key : keys){
        	Collections.sort(idx.get(key));
            for (int val : idx.get(key)) bw.write(String.format("%d %d\n", key, val));
        }
         
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}